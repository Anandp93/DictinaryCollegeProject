package com.example.dictinarycollegeproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public class DictionaryLoader {

	public static void loadData(BufferedReader bufferedReader, DictionaryDatabaseHelper dictionaryDatabaseHelper)
	{
		ArrayList<WordDefinition> allWords=new ArrayList<WordDefinition>();
		try
		{
			
			BufferedReader fileReader=bufferedReader;
			try
			{
				int c=17;
				c=fileReader.read();
				while(c!=(-1))
				{
					StringBuilder stringBuilder=new StringBuilder();
					while((char)c!='\n'&& c!=-1)
					{
					try{
						stringBuilder.append((char)c);
					}catch(Exception e)
					{
					System.out.println(stringBuilder.length());
					//e.printStackTrace();
					}	
						
					c=fileReader.read();
					if(c==-1)
					{
						return;
					}
						
					}
					String wordString=stringBuilder.toString();
					ArrayList<String> definition=new ArrayList<String>();
					while(c=='\n'||c=='\t')
					{
						c=fileReader.read();
						if(c=='\n'||c=='\t'||c=='\r')
						{
							StringBuilder stringBuilder2=new StringBuilder();
							while(c!='\n')
							{
							
								stringBuilder2.append((char)c);
								c=fileReader.read();
							
							
						}
						String definationString=stringBuilder2.toString();
								definition.add(definationString);
						}
						else{
							break;
							
						}
					}
					wordString =wordString.trim();
							allWords.add(new WordDefinition(wordString, definition));
							
				}
			}
				catch(IOException e){
				e.printStackTrace();
			}
			try
			{
				dictionaryDatabaseHelper.initialiseDatabaseFortheFirstTime(allWords);
			
				
				fileReader.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			
			
			
		}
		}
		finally{
		}
	}
		
		
	}

