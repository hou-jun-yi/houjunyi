package character;
//狐狸너구리
public class Paccoon extends Monster {
	public  Paccoon() {
		super.name = "너구리";
	    super.hp = 400;
	    super.defense = 5;
	    super.power = 20;
	    super.mp = 0;
	    super.level = 1;
	    super.experience = 20;
	    super.money = 10;
	}
	public  int attack(Hero hero) {
		
	    
	    System.out.println(name + "를 공격합니다");                          
		if(hero.defense >=  power) {                                   
			System.out.println(hero.name + "다치지 않았습니다!");                      
		}else{                                                                 
			hero.hp = hero.hp + hero.defense - power;                  
			System.out.println(hero.name + "받았" +power + "데미지 찍기!");	
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
