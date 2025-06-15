package character;
//野狗
public class WildDog extends Monster{
	public  WildDog() {
		super.name = "들개 ";   
		super.hp = 2500;      
		super.defense = 40;   
		super.power = 130;    
		super.mp = 10;         
		super.level = 10;      
		super.experience = 100;
		super.money = 50;
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
