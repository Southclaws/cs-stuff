/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialmusicclient;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class MainPage extends javax.swing.JFrame
{
	private Vector<String> Friends = new Vector<>();
	private Vector<String> Posts;

	public String username_;
	public String information_;
	public String targetUsername_;
	private SocketConnection server_;
	private boolean playing_;
	private BasicPlayer player_;
	private String playingFile_;

	public MainPage(SocketConnection server, String username, String information)
	{
		initComponents();

		username_ = username; // set field to passed in username
		information_ = information;
		server_ = server;
		player_ = new BasicPlayer();
		
		UpdateEverything();

		jInternalFrame1.setTitle("NTU Music Social Network: " + username);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        FriendsLst = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InformationTA = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        SharedSongsLst = new javax.swing.JList<>();
        PlayBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PostTxt = new javax.swing.JTextField();
        SendBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ServerLst = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        FriendRequestsLst = new javax.swing.JList<>();
        RequestFriendshipBtn = new javax.swing.JButton();
        ChatBtn = new javax.swing.JButton();
        AcceptBtn = new javax.swing.JButton();
        RefuseBtn = new javax.swing.JButton();
        LogOutBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        PostsLst = new javax.swing.JList<>();
        RemoveFriendBtn = new javax.swing.JButton();
        DeletePostBtn = new javax.swing.JButton();
        PlayBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setResizable(true);
        jInternalFrame1.setTitle("NTU Music Social Network: ");
        jInternalFrame1.setVisible(true);

        jLabel1.setText("Friends");

        jScrollPane1.setViewportView(FriendsLst);

        jLabel2.setText("Information");

        jLabel3.setText("Shared Songs");

        InformationTA.setColumns(20);
        InformationTA.setRows(5);
        jScrollPane2.setViewportView(InformationTA);

        jScrollPane3.setViewportView(SharedSongsLst);

        PlayBtn.setText("Play");
        PlayBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                PlayBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Friend Posts");

        jLabel5.setText("Post:");

        SendBtn.setText("Send");
        SendBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                SendBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("People on your Server");

        jLabel7.setText("Friend Requests From");

        jScrollPane5.setViewportView(ServerLst);

        jScrollPane6.setViewportView(FriendRequestsLst);

        RequestFriendshipBtn.setText(" Request Friendship");
        RequestFriendshipBtn.setToolTipText("");
        RequestFriendshipBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                RequestFriendshipBtnActionPerformed(evt);
            }
        });

        ChatBtn.setText("Chat");
        ChatBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ChatBtnActionPerformed(evt);
            }
        });

        AcceptBtn.setText("Accept");
        AcceptBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                AcceptBtnActionPerformed(evt);
            }
        });

        RefuseBtn.setText("Refuse");
        RefuseBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                RefuseBtnActionPerformed(evt);
            }
        });

        LogOutBtn.setText("Log out");
        LogOutBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                LogOutBtnActionPerformed(evt);
            }
        });

        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                UpdateBtnActionPerformed(evt);
            }
        });

        jScrollPane7.setViewportView(PostsLst);

        RemoveFriendBtn.setText("Remove");
        RemoveFriendBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                RemoveFriendBtnActionPerformed(evt);
            }
        });

        DeletePostBtn.setText("Delete Post");
        DeletePostBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                DeletePostBtnActionPerformed(evt);
            }
        });

        PlayBtn1.setText("Share");
        PlayBtn1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                PlayBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jScrollPane7)
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RefuseBtn)
                                            .addComponent(AcceptBtn)
                                            .addComponent(UpdateBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LogOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(RequestFriendshipBtn)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(RemoveFriendBtn)
                                                    .addComponent(ChatBtn)))
                                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2)))
                                    .addComponent(jLabel4))
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PlayBtn1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PlayBtn))
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PostTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SendBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeletePostBtn)))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(RemoveFriendBtn)
                        .addGap(18, 18, 18)
                        .addComponent(ChatBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PlayBtn)
                        .addComponent(PlayBtn1))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeletePostBtn)
                    .addComponent(PostTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SendBtn)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(AcceptBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RefuseBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UpdateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LogOutBtn))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5)
                            .addComponent(jScrollPane6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RequestFriendshipBtn)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void SendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendBtnActionPerformed
		String Post;
		Post = PostTxt.getText();
		PostTxt.setText("");
		if(Post.isEmpty())
		{
			return;
		}
		else
		{
			Post = "ADDP " + username_ + " \"" + Post + "\"" + "\n";
			server_.send(Post);
			System.out.println("UpdateEverything");
			UpdateEverything();
		}
		// TODO add your handling code here:
	}//GEN-LAST:event_SendBtnActionPerformed

	private void ChatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChatBtnActionPerformed
		Object Selection = FriendsLst.getSelectedValue();
		
		if(Selection == null)
			return;

		targetUsername_ = Selection.toString();

		String reply = server_.send("CHAT " + username_ + " " + targetUsername_ + "\n");
		
		if(reply.equals("SUCCESS"))
		{
			new PrivateChat(server_, username_, targetUsername_).setVisible(true);        // TODO add your handling code here:
		}
		else
		{
			// errir
			System.out.println("CHAT ERROR");
		}
	}//GEN-LAST:event_ChatBtnActionPerformed

	private void LogOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutBtnActionPerformed
		this.setVisible(false);
		new Login(server_).setVisible(true);    // TODO add your handling code here:
	}//GEN-LAST:event_LogOutBtnActionPerformed

	private void AcceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptBtnActionPerformed
		Object Selection = FriendRequestsLst.getSelectedValue();

		//Object Selection
		if(Friends.contains(Selection.toString()))
		{
			return;
		}

		server_.send("ADDF " + username_ + " " + Selection.toString() + "\n");
		server_.send("DELR " + username_ + " " +Selection.toString() + "\n");

		UpdateEverything();
// TODO add your handling code here:
	}//GEN-LAST:event_AcceptBtnActionPerformed

	private void RefuseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefuseBtnActionPerformed
		Object Selection = FriendRequestsLst.getSelectedValue();
		
		if(Selection == null)
			return;

		server_.send("DELR " + username_ + " " +Selection.toString() + "\n");
		UpdateEverything();
// TODO add your handling code here:
	}//GEN-LAST:event_RefuseBtnActionPerformed

	private void RemoveFriendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveFriendBtnActionPerformed
		Object Selection = FriendsLst.getSelectedValue();
		
		if(Selection == null)
			return;

		server_.send("DELF " + username_ + " " +Selection.toString() + "\n");
		UpdateEverything();
	}//GEN-LAST:event_RemoveFriendBtnActionPerformed

	private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
		UpdateEverything();
	}//GEN-LAST:event_UpdateBtnActionPerformed

	private void DeletePostBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletePostBtnActionPerformed
		Object Selection = PostsLst.getSelectedValue();
		
		if(Selection == null)
			return;

		server_.send("DELP " + username_ + " " +Selection.toString() + "\n");
		UpdateEverything();
	}//GEN-LAST:event_DeletePostBtnActionPerformed

    private void PlayBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_PlayBtnActionPerformed
    {//GEN-HEADEREND:event_PlayBtnActionPerformed
		if(playing_)
		{
			try
			{
				player_.pause();
			}
			catch(BasicPlayerException e)
			{
				e.printStackTrace();
			}
			playing_ = false;
			PlayBtn.setText("Play");
			playingFile_ = "";
		}
		else
		{
			String filename;

			filename = SharedSongsLst.getSelectedValue();
			String filepath = "./music/" + filename;
			Path p = Paths.get(filepath);

			if(!Files.exists(p, LinkOption.NOFOLLOW_LINKS))
			{
				byte[] data = server_.sendb("MGET " + username_ + " \"" + filename + "\"");

				try
				{
					Files.write(p, data, StandardOpenOption.CREATE);
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}

			try
			{
				player_.open(new File(filepath));
				player_.play();
				playing_ = true;
				PlayBtn.setText("Pause");
				playingFile_ = filename;
			}
			catch(BasicPlayerException e)
			{
				e.printStackTrace();
			}
		}
    }//GEN-LAST:event_PlayBtnActionPerformed

    private void PlayBtn1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_PlayBtn1ActionPerformed
    {//GEN-HEADEREND:event_PlayBtn1ActionPerformed
		if(playingFile_ != "")
		{
			server_.send("ADDP " + username_+ " \"Listening to: " + playingFile_ + "\"");
			UpdateEverything();
		}
    }//GEN-LAST:event_PlayBtn1ActionPerformed

    private void RequestFriendshipBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RequestFriendshipBtnActionPerformed
    {//GEN-HEADEREND:event_RequestFriendshipBtnActionPerformed
		Object Selection = ServerLst.getSelectedValue();
		
		if(Selection == null)
			return;

		server_.send("ADDR " + Selection.toString() + " " + username_ + "\n");
		System.out.println(Selection.toString());
		UpdateEverything();
    }//GEN-LAST:event_RequestFriendshipBtnActionPerformed

	private void UpdateEverything()
	{
		System.out.println("UpdateEverything");

		// get friends and add to list
		String[] FriendsArr = server_.send("FRND " + username_).split("\\s+");
		System.out.format("FRND: [0] = '%s' length: %d\n", FriendsArr[0], FriendsArr.length);

		if(FriendsArr[0].equals("FRIENDS") && FriendsArr.length > 1)
		{
			Vector<String> Friends = new Vector<>();
			for(int i = 1; i < FriendsArr.length; ++i)
			{
				System.out.format("FRIENDS: '%s'\n", FriendsArr[i]);
				Friends.add(FriendsArr[i]);
			}
			FriendsLst.setListData(Friends);
		}
		else
		{
			FriendsLst.setListData(new Vector<>());
		}

		// get friend requests and add to list
		String[] FriendReqArr = server_.send("REQS " + username_).split("\\s+");
		System.out.format("REQS: [0] = '%s' length: %d\n", FriendReqArr[0], FriendReqArr.length);

		if(FriendReqArr[0].equals("FRIENDS") && FriendReqArr.length > 1)
		{
            Vector<String> FriendReqs = new Vector<>();
            for(int i = 1; i < FriendReqArr.length; ++i)
            {
				System.out.format("REQS: '%s'\n", FriendReqArr[i]);
                FriendReqs.add(FriendReqArr[i]);
            }
			FriendRequestsLst.setListData(FriendReqs);
		}
		else
		{
			FriendRequestsLst.setListData(new Vector<>());
		}

		// get posts and add to list
		String[] PostsArr = server_.send("GETP " + "\n").split("\\t");
		System.out.format("GETP: [0] = '%s' length: %d\n", PostsArr[0], PostsArr.length);

		if(PostsArr[0].equals("POSTS") && PostsArr.length > 1)
		{
			Vector<String> Posts = new Vector<>();
			for(int i = 1; i < PostsArr.length; ++i)
			{
				System.out.format("POSTS: '%s'\n", PostsArr[i]);
				Posts.add(PostsArr[i]);
			}
			PostsLst.setListData(Posts);
		}
		else
		{
			PostsLst.setListData(new Vector<>());
		}

		// get online friends and add to list
		String[] OnlinePeopleArr = server_.send("ONLN\n").split("\\s+");
		System.out.format("ONLN: [0] = '%s' length: %d\n", OnlinePeopleArr[0], OnlinePeopleArr.length);

		if(OnlinePeopleArr[0].equals("USERS") && OnlinePeopleArr.length > 1)
		{
			Vector<String> OnlinePeople = new Vector<>();
			for(int i = 1; i < OnlinePeopleArr.length; ++i)
			{
				System.out.format("USERS: '%s'\n", OnlinePeopleArr[i]);
				OnlinePeople.add(OnlinePeopleArr[i]);
			}
			ServerLst.setListData(OnlinePeople);
		}
		else
		{
			ServerLst.setListData(new Vector<>());
		}

		// get music files and add to list
		String[] ChatRequestsArr = server_.send("CHTR " + username_ + "\n").split("\\s+");
		System.out.format("CHTR: [0] = '%s' length: %d\n", ChatRequestsArr[0], ChatRequestsArr.length);

		if(ChatRequestsArr[0].equals("CHAT") && OnlinePeopleArr.length > 1)
		{
			for(int i = 1; i < ChatRequestsArr.length; ++i)
			{
				System.out.format("CHATR: '%s'\n", ChatRequestsArr[i]);
				new PrivateChat(server_, username_, ChatRequestsArr[i]).setVisible(true);
			}
		}

		// get shared music files list
		ArrayList<String> SharedSongsArr = new ArrayList<>();

		Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(server_.send("MLST\n"));
		
		while(m.find())
			SharedSongsArr.add(m.group(1));

		if(SharedSongsArr.get(0).equals("FILES") && SharedSongsArr.size() > 1)
		{
			Vector<String> SharedSongs = new Vector<>();
			for(int i = 1; i < SharedSongsArr.size(); ++i)
			{
				System.out.format("MLST: '%s'\n", SharedSongsArr.get(i));
				SharedSongs.add(SharedSongsArr.get(i).substring(1, SharedSongsArr.get(i).length() - 1));
			}
			SharedSongsLst.setListData(SharedSongs);
		}
		else
		{
			SharedSongsLst.setListData(new Vector<>());
		}
		
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptBtn;
    private javax.swing.JButton ChatBtn;
    private javax.swing.JButton DeletePostBtn;
    private javax.swing.JList<String> FriendRequestsLst;
    private javax.swing.JList<String> FriendsLst;
    private javax.swing.JTextArea InformationTA;
    private javax.swing.JButton LogOutBtn;
    private javax.swing.JButton PlayBtn;
    private javax.swing.JButton PlayBtn1;
    private javax.swing.JTextField PostTxt;
    private javax.swing.JList<String> PostsLst;
    private javax.swing.JButton RefuseBtn;
    private javax.swing.JButton RemoveFriendBtn;
    private javax.swing.JButton RequestFriendshipBtn;
    private javax.swing.JButton SendBtn;
    private javax.swing.JList<String> ServerLst;
    private javax.swing.JList<String> SharedSongsLst;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables
}
