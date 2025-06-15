package character;
//法师마법사
public class Wizard extends Hero {
	public Wizard() {
		super.level = 1;     
		super.power = 15;    
		super.defense = 25;  
		super.hp = 200;       
		super.mp = 20; 
	}
	
	public int attack(Monster monster) {
		
		//天女散花技能，造成大量伤害，并且使自身血量减少5点
		//천녀산화는 기술은사용할 때, 이로 인해 대량의 피해를 입히다
		 System.out.println("당신은 만났 "+ monster.name + "괴물! 전투가 시작됩니다!");
		 System.out.println(name + "의 공격입니다");
		 System.out.println(name + "의 공격입니다");
		 System.out.println("공격 방식을 선택하세요.1.보통 공격.2.천녀산화");
		 int attackMethodSelection = scanner.nextInt();
		 
		 if (attackMethodSelection == 1) {
			 harm = level * 10 + power * 25 + mp*15;

		 }else if (attackMethodSelection==2) {
			 
				 harm = level * 15 + power * 25 + mp*20;
		}else {
			 System.out.println("잘못 입력하였습니다. 다시 입력해 주세요");
		 }
                                             
		return harm;
	}


}
