public class Country
{
  // add private instance variables for the name, capital, language, and image file.
private String name;
private String capital;
private String language;
private String imageFile;
  // add constructors
  public Country() {
    name = "";
    capital = "";
    language = "";
    imageFile = "";
  }
  public Country(String name1, String capital1, String language1, String imageFile1) {
    name = name1;
    capital = capital1;
    language = language1;
    imageFile = imageFile1;
  }

  // Write accessor/get methods for each instance variable that returns it.
public void Setname(String x){
name = x;
}
public void Setcapital(String x){
capital = x;
}
public void Setlanguage(String x){
language = x;
}
public void SetimageFile(String x){
imageFile = x;
}
public String Getname(){
  return name;
}
public String Getcapital(){
  return capital;
}
public String Getlanguage(){
  return language;
}
public String GetimageFile(){
  return imageFile;
}
  // Write a toString() method that returns a concatenated String of 3 of the instance variables in a sentence like "..'s capital is .. and its primary language is ..."
 public String toString(){
 return name + " capital is " + capital + " and its primary language is " + language;
 }


  
}