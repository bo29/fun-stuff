import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
public class MontyHall {
	private static boolean decision(){
		return Math.random()<0.5;//for randomly choosing if the user switches; i ended up never using it
	}
	public static void main(String[] args) {
		Random rand=new Random();
		int trials=0, num=0, cars=0, carsSwitched=0, total=0, totalSwitched=0, count=0, temp=0, falseDoor=0;
		boolean choice=false;//decision();
		HashMap<Integer, String> map=new HashMap<Integer, String>();
		Set<Integer> doors=new LinkedHashSet<Integer>();
		final String goat="goat";
		final String car="brand new car";
		while(trials<20000000){//adjust the size however much you want
			while(doors.size()<3){//randomly places goats and car behind doors
				num=rand.nextInt(3)+1;
				if(doors.contains(num))
					continue;
				doors.add(rand.nextInt(3)+1);
			}
			for(int i: doors){//saves locations of goats and car
				if(count<2)
					map.put(i, goat);
				else
					map.put(i, car);
				count++;
			}
			num=rand.nextInt(3)+1;
			falseDoor=rand.nextInt(3)+1;
			while(car.equals(map.get(falseDoor)) || falseDoor==num){
				falseDoor=rand.nextInt(3)+1;//chooses which goat door to open
			}
			temp=num;
			if(choice){//if the user switches, this finds out which door to switch to
				while(num==temp || num==falseDoor)
					num=rand.nextInt(3)+1;
			}
			if(map.get(num).equals(goat)){//counts up the various totals
				if(choice){
					totalSwitched++;
				}
				else{
					total++;
				}
			}
			else if(map.get(num).equals(car)){
				if(choice){
					carsSwitched++;
					totalSwitched++;
				}
				else{
					cars++;
					total++;
				}
			}
			trials++;
			count=0;
			doors.clear();
			if(trials>=10000000)
				choice=true;//decision();
		}
		float wonSwitched=((float)carsSwitched/(float)totalSwitched)*100;
		float won=((float)cars/(float)total)*100;
		System.out.println("Percentage won with switching: "+wonSwitched+"% with "+carsSwitched+" cars won out of "+totalSwitched+" trials.");
		System.out.println("Percentage won without switching: "+won+"% with "+cars+" cars won out of "+total+" trials.");
	}
}