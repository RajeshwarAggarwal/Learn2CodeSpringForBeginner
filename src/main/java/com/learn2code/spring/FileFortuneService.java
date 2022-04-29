package com.learn2code.spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class FileFortuneService implements FortuneService{

    private String fileName = "C:/Learn2Code/Learn2CodeSpring/src/main/resources/fortune-data.txt";
    private List<String> theFortunes;

    // create a random number generator
    private Random myRandom = new Random();

    @PostConstruct
    public void initialiseFortuneList(){
        File theFile = new File(fileName);
        System.out.println("Inside FileFortuneService.PostConstruct: Reading Fortune from files!");
        System.out.println("Inside FileFortuneService.PostConstruct: File Exist : "+theFile.exists());

        //iniialise arrayList

        theFortunes = new ArrayList<String>();

        // read from file
        try(BufferedReader br = new BufferedReader(new FileReader(theFile))){
            String tempLine;
            while((tempLine=br.readLine())!=null){
                theFortunes.add(tempLine);
            }
        }catch (IOException e ){
            Logger.getLogger("FileFortuneService").log(Level.INFO,"Cannot open a file to read");
        }

    }


    @Override
    public String getFortune() {
        int index = myRandom.nextInt(theFortunes.size());
        return theFortunes.get(index);
    }
}
