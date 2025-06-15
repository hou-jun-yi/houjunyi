package character;
//野猫 살쾡이
public class WildCat extends Monster {
	public WildCat() {
		super.name = "살쾡이";   
		super.hp = 1500;      
		super.defense = 20;   
		super.power = 100;    
		super.mp = 5;         
		super.level = 5;      
		super.experience = 50;
		super.money = 30;     
	}
	public  int attack(Hero hero) {
		
	    System.out.println(name + "를 공격합니다");
	    
		if(hero.defense >= mp+ power) {                                   
			System.out.println(hero.name + "다치지 않았습니다!");                      
		}else{                                                                 
			hero.hp = hero.hp + hero.defense - power - mp;                  
			System.out.println(hero.name + "받았" +power + mp + "데미지 찍기!");	
		}                                                                      
		return 0;
	}
	
	public void attacked(Hero hero) {
		if( hero.hp <= 0) {                        
			System.out.println("히어로가 죽었습니다");	   
			System.out.println("히어로가 부활했습니다");     
			                                                                                 
		} 
	}

}
