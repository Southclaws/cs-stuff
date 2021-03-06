/*==============================================================================

    Systems Software Project

    Social Music Server

    Barnaby Keene 2016

==============================================================================*/


package socialmusicserver;

import socialmusicserverchat.SocialMusicServerChat;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserManager implements EventListener
{
	private static UserManagerDB udb;
	private static SocialMusicServerChat chat_;
	
	private static Vector<User> UserList = new Vector<>();

	public void init(SocialMusicServerChat chat)
	{
		udb = UserManagerDB.inst();
		chat_ = chat;
/*
		ArrayList<String> l = new ArrayList<>();
		
		l.add("1");
		l.add("2");
		l.add("3");
		
		udb.RegisterUser("Southclaw", "pass", l);
		udb.RegisterUser("Relation", "pass", l);
		
		udb.addUserFriend("Southclaw", "Relation");
		udb.addUserFriendReq("Relation", "Southclaw");
*/
	}

	@Override
	public NetMessage msgRecv(ListenEvent event)
	{
		// DEBUG
		//System.out.println("\n\nmsgRecv PARAM DEBUG:");
		//for(String s: event.args())
		//{
		//	System.out.println(s);
		//}
		//System.out.println("msgRecv END PARAM DEBUG\n\n");
		// END DEBUG

		NetMessage reply = new NetMessage("NULL");

		switch(event.args()[0])
		{
			// connect and disconnect
			case "CONN":
			{
				break;
			}

			case "DSCN":
			{
				for(User u : UserList)
				{
					if(u.RemoteAddress.equals(event.addr()))
					{
						UserList.remove(u);
						break;
					}
				}

				break;
			}

			case "REGS":
			{
				// a[1] is username
				// a[2] is password hash
				// a[3] is DoB
				// a[4] is PoB
				// a[5+]is music preference list
				ArrayList<String> musicProfile = new ArrayList<>();

				if(event.args().length > 4)
				{
					for(int i = 5; i < event.args().length; ++i)
					{
						musicProfile.add(event.args()[i]);
					}
				}

				int ret = udb.RegisterUser(event.args()[1], event.args()[2], musicProfile);

				if(ret == 0)
					reply.txt = "SUCCESS";

				if(ret == 1)
					reply.txt = "FAILEX";

				if(ret == 2)
					reply.txt = "FAILDB";
				
				break;
			}

			case "LOGN":
			{
				// a[1] is username
				// a[2] is password hash
				// return user ID (positive integer/UUID) or -1 for failure
				int ret = udb.LoginUser(event.args()[1], event.args()[2]);

				if(ret == 0)
				{
					UserList.add(new User(event.addr(), event.args()[1], event.args()[2]));
					reply.txt = "SUCCESS";
				}

				if(ret == 1)
					reply.txt = "FAILEX";

				if(ret == 2)
					reply.txt = "FAILDB";

				if(ret == 3)
					reply.txt = "FAILPW";
				
				break;
			}

			case "DETL":
			{
				// a[1] is userid
				// return user details string
				// username (correctly capitalised) reg date, last login, etc
				reply.txt = udb.getUserInfo(event.args()[1]);
				break;
			}

			case "FRND":
			{
				// a[1] is userid
				// return friends list
				reply.txt = udb.getUserFriends(event.args()[1]);
				break;
			}

			case "ADDF":
			{
				// a[1] is userid
				// a[2] is friend userid
				// return success/error code
				reply.txt = udb.addUserFriend(event.args()[1], event.args()[2]);
				break;
			}

			case "DELF":
			{
				// a[1] is userid
				// a[2] is friend userid
				// return success/error code
				reply.txt = udb.delUserFriend(event.args()[1], event.args()[2]);
				break;
			}

			case "REQS":
			{
				// a[1] is userid
				// return friends list
				reply.txt = udb.getUserFriendReqs(event.args()[1]);
				break;
			}

			case "ADDR":
			{
				// a[1] is userid
				// a[2] is friend userid
				// return success/error code
				reply.txt = udb.addUserFriendReq(event.args()[1], event.args()[2]);
				break;
			}

			case "DELR":
			{
				// a[1] is userid
				// a[2] is friend userid
				// return success/error code
				reply.txt = udb.delUserFriendReq(event.args()[1], event.args()[2]);
				break;
			}

			case "ONLN":
			{
				reply.txt = GetOnlineUsersString();
				break;
			}

			case "GETP":
			{
				reply.txt = udb.getPostsList();
				break;
			}

			case "ADDP":
			{
				reply.txt = udb.addPublicPost(event.args()[1], event.args()[2]);
				break;
			}

			case "DELP":
			{
				reply.txt = udb.delPublicPost((event.args()[1]));
				break;
			}

			/*
			CHAT command:
			first paramter is the user requesting a chat and second parameter is
			user they want to chat to. This adds the first user to a list stored
			in the second user's structure where the CHTR command reads from.
			When a user requests a chat with another user, that other user has
			to update their client which will trigger the private chat to start.
			The return value is the string "FAILEX" if the request failed
			because either user didn't exist. Otherwise this command returns
			"SUCCESS" if the chat request was submitted successfully.
			*/
			case "CHAT":
			{
				User u1 = GetUserFromName(event.args()[1]);
				User u2 = GetUserFromName(event.args()[2]);

				if(u1 == null || u2 == null)
				{
					reply.txt = "FAILEX";
					break;
				}

				u2.AddChatRequest(u1);

				reply.txt = "SUCCESS";
				break;
			}

			/*
			CHTR command:
			Chat Requests command will retrieve a list of chat requests for a
			user. This list consists of the names of users who want to chat with
			the user specified in the first argument. Users who want to chat are
			added with the "CHAT" command above. This command returns the string
			"CHAT" followed by the names of users requesting a chat separated by
			spaces. The list of users requesting a chat is stored in User obj.
			*/
			case "CHTR":
			{
/*				User u = GetUserFromName(event.args()[1]);
				
				Vector<User> r = u.ChatRequests;
				
				String reply = "CHAT";
				
				for(User iu : r)
				{
					reply += " " + iu.Username;
				}

				reply.txt = reply;
				break;*/
			}
			
			/*
			MLST command:
			lists music files in the music directory.
			*/
			case "MLST":
			{
				// username
				String list = "FILES";
				File dir = new File("./music");
				File[] filesList = dir.listFiles();
				String filename;
				for (File file : filesList)
				{
					filename = "\"" + file.getName() + "\"";
					if (file.isFile())
					{
						list += " " + filename;
					}
				}
				
				reply.txt = list;
				break;
			}

			/*
			MGET command:
			gets a specific music file by filename.
			*/
			case "MGET":
			{
				try
				{
					// Todo: check if user has access to file
					Path p = Paths.get("./music/" + event.args()[2].substring(1, event.args()[2].length() - 1));
					byte[] fileBytes = Files.readAllBytes(p);

					reply.type = NetMessage.NMT.BIN;
					reply.bin = fileBytes;
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				break;
			}
		}

		return reply;
	}

	public String GetOnlineUsersString()
	{
		String output = "USERS";

		for(User u : UserList)
		{
			output += " " + u.Username;
		}
	
		return output;
	}

	public User GetUserFromIP(String ip)
	{
		for(User u : UserList)
		{
			if(u.RemoteAddress.equals(ip))
			{
				return u;
			}
		}
		
		return null;
	}

	public User GetUserFromName(String name)
	{
		for(User u : UserList)
		{
			if(u.Username.equals(name))
			{
				return u;
			}
		}
		
		return null;
	}
	// Singleton stuff
	
	private static UserManager instance = new UserManager();
	
	private UserManager(){}
	
	public static UserManager inst()
	{
		return instance;
	}
}
