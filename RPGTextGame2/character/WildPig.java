package character;
//野猪
public class WildPig extends Monster {
	public  WildPig() {
		super.name = "멧돼지 ";   
		super.hp = 3000;      
		super.defense = 80;   
		super.power = 170;    
		super.mp = 20;         
		super.level = 15;      
		super.experience = 150;
		super.money = 100;
	}
	//怪物攻击 괴물 공격
	public  int attack(Hero hero) {
		
		
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
