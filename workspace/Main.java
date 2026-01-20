import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.List;
import java.io.*;




// Germany,Berlin,German,Germany.jpg
// India,New Delhi,Hindi,India.jpg
// Japan,Tokyo,Japanese,Japan.jpg
// Kenya,Nairobi,Swahili,Kenya.jpg
// Mexico,Mexico City,Spanish,Mexico.jpg
// United Kingdom,London,English,UK.jpg
// United States,Washington D.C.,English,US.jpg
public class Main 
{
  public Country China;
  public Country Egypt;
  public Country France;
  public Country Germany;
  public Country India;
  public Country Japan;
  public Country Kenya;
  public Country Mexico;
  public Country UnitedKingdom;
  public Country UnitedStates;

  // array of 10 Country objects
  private Country[] countryArray = new Country[10];  
  // index of current shown country
  private int index = 0;

  // GUI elements
  private JFrame jFrame = new JFrame("Countries");
  private ImageIcon img;
  private JLabel imageLabel;
  private JLabel outputLabel;
  private JTextArea userInput;

  public static void main(String[] args) {
    // Create the GUI
    Main gui = new Main();
    gui.loadCountries();
    gui.showCountry();
  }

  /* loadCountries() reads in the data from the countries-data.csv file and fills in the countryArray with data. You need to add the loop that reads in the country data into the array. */
  //create a scanner and a loop to read from the file until you've read everything.
  public void loadCountries() 
  {
   
    try 
{   
    
    File file = new File("/workspaces/Countries/workspace/countries-data.csv");
    Scanner scan = new Scanner(file);
    String line = "";
    int i = 0;
      while (scan.hasNext()){
        line = scan.nextLine();
        String[] items = line.split(",");
        Country tmp_Country = new Country(items[0],items[1],items[2],items[3]);
        countryArray[i] = tmp_Country;
        i++;
      }
for (Country country : countryArray) {
    String name = country.Getname();
    String capital = country.Getcapital();
    String language = country.Getlanguage();
    String imageFile = country.GetimageFile();
    System.out.println(name + " " + capital + " " + language + " " + imageFile);
}
    

  scan.close();
    
}
catch (FileNotFoundException e) 
{                   
    System.out.println("File not found!");
}

    
  
   
    
  
    // inside the loop you'll need to read in a line from the file and use "split" to break up the data into destinct parts.

    // create a new Country using your constructor with 4 arguments (each of the arguments is a different part of the line you've read in)

    // inside the loop, set countryArray[i] to the created Country object

    //after running this method your array should contain all 10 countries from inside the countries-data file.

     
    
  }

 

  /* showCountry() will show the image associated with the current country. It should get the country at index from the countryArray. It should use its get method to get its image file name and use the code below to put the image in the GUI.
  */
  public void showCountry() {
    // Get the country at index from countryArray
    Country CurrentCountry = countryArray[index];
    // Use its get method to get the its image file name and save it into imagefile variable below instead of worldmap.jpg.
    String imagefile = "worldmap.jpg";
    imagefile = CurrentCountry.GetimageFile();
    // Use the following code to create an new Image Icon and put it into the GUI
    img = new ImageIcon("/workspaces/Countries/workspace/"+imagefile);
    imageLabel.setIcon(img);
  }
  
  /* nextButton should increment index. If the index is greater than 9, reset it back to 0. Clear the outputLabel to empty string using setText, and call showCountry();*/
  public void nextButtonClick()
  {
    if ( index < 9 ){
      index = index + 1;
    }
    else {
      index = 0;
    }
    outputLabel.setText("what country is this?");
    showCountry();
  }
  
  /* reviewButton should get the country at index from the countryArray, call its toString() method and save the result, print it out with System.out.println and as an argument to outputLabel.setText( text to print out ); */
  public void reviewButtonClick()
  {
    System.out.println(countryArray[index].toString()); 
    outputLabel.setText( countryArray[index].toString() );
  }

  /* quizButton should clear the outputLabel (outputLabel.setText to empty string), get the country at index from countryArray, print out a question about it like What country is this? and/or What's this country's capital?. Get the user's answer using scan.nextLine() and check if it is equal to the country's data using its get methods and print out correct or incorrect.
  */
  public void quizButtonClick()
  {
  
    Country CurrentCountry = countryArray[index];
    String answer = userInput.getText();
    if ( answer.toLowerCase().equals( CurrentCountry.Getname().toLowerCase() ) ){
      System.out.println("Correct!");
      outputLabel.setText("Correct!");
    }
    else {
      System.out.println("Incorrect!");
      outputLabel.setText("Incorrect!");
    }
    
    
  }




  /* You are not required to change anythign below here. You do so at your own risk! */
  /* The Main() constructor is finished and will construct the GUI */
public Main() {
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons at the top
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
        
        // create a new image icon
        img = new ImageIcon("worldmap.jpg");
        // create a label to display image
        imageLabel = new JLabel(img);
        // and one for output
        outputLabel = new JLabel();
        jFrame.add(imageLabel);
        jFrame.add(outputLabel);
       
        userInput = new JTextArea(5, 40);
        userInput.setBackground(Color.LIGHT_GRAY); 
        jFrame.add(userInput);
        jFrame.setVisible(true);
        // add event listener for button click
        reviewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      reviewButtonClick();
    }
        });
    quizButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      quizButtonClick();
    }
    });
   
   newButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e) 
    {
      nextButtonClick();
    }
   });
}
  

}
