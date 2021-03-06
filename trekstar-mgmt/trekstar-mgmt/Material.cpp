/*
	Material
*/
#include <string>
#include <sstream>

#include "Material.h"

using std::string;


Material::Material(string id, string title, string format, string audio, int duration, string language, string price, string aspect, Packaging packaging)
{
	id_ = id;
	title_ = title;
	format_ = format;
	audio_ = audio;
	duration_ = duration;
	language_ = language;
	price_ = price;
	aspect_ = aspect;
	packaging_ = packaging;
}

std::string Material::details()
{
	std::stringstream s;

	s << "ID: " << id_ << ", "
		<< "Title: " << title_ << ", "
		<< "Format: " << format_ << ", "
		<< "Audio: " << audio_ << ", "
		<< "Duration: " << duration_ << ", "
		<< "Language: " << language_ << ", "
		<< "Price: " << price_ << ", "
		<< "Aspect: " << aspect_ << ", "
		<< "Packaging: " << packaging_.toString();

	return s.str();
}

string Material::GetId()
{
	return id_;
}

string Material::GetTitle()
{
	return title_;
}

string Material::GetFormat()
{
	return format_;
}

string Material::GetAudio()
{
	return audio_;
}

int Material::GetDuration()
{
	return duration_;
}

string Material::GetLanguage()
{
	return language_;
}

string Material::GetPrice()
{
	return price_;
}

string Material::GetAspect()
{
	return aspect_;
}

Packaging Material::GetPackaging()
{
	return packaging_;
}
