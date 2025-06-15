package character;
//怪物基础面版 몬스터 베이스 패널
public class Monster extends Character {
	public int power;//力量
	public int defense;//防御力
	public int money ;
	public int experience;//经验
	
	//怪物攻击 괴물 공격
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
	//判断英雄死亡 판단 영웅 사망
	public void attacked(Hero hero) {
		if( hero.hp <= 0) {                        
			System.out.println("히어로가 죽었습니다");	   
			System.out.println("히어로가 부활했습니다");     
			                                                                                 
		}                                          
		
	}
	
}
