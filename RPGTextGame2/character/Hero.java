package character;

import java.util.Scanner;

import map.Mission;

//英雄基础面板영웅 기본 패널
public class Hero extends Character {
	/**public Hero (){
		this.power=power;
		this.defense=defense;
	}*/
	public int power;//力量 힘
	public int defense;//防御力방어
	public int money = 0;
	public int experience = 0;//经验	경험
	public int harm;//伤害 피해

	
	
	public  int  attack(Monster monster) {
		 System.out.println("당신은 만났 "+ monster.name + "괴물! 전투가 시작됩니다!");
		 System.out.println(name + "의 공격입니다");
		 harm = level * 10 + power * 30;                                                 
		return harm;
	}
	
	public void attacked(int harm,Monster monster) {
		if (harm >=  monster.defense) {                                      
			 monster.hp = monster.hp + monster.defense - harm;               
		} else {                                                             
			System.out.println(monster.name + "방어력이 너무 높아서 해롭지 않습니다.");      
		}            
		 if( monster.hp <= 0) {
			 System.out.println(monster.name +  "가 죽었습니다");
			 experience += monster.experience;
			 money += monster.money;
			 HeroUpgrade();
			
		}
		
	}
	//英雄升级 영웅의 진급
	 public void HeroUpgrade() {
		if (experience >= level * 100) {
			level += 1;
			System.out.println("레벨을 증가했습니다");
			money += 50;
			hp+=level*2;
			experience = 0;
			Mission.checkLevelUpMission(this);
		}
	}

	
}
