package character;
//战士전사
public class Warrior extends Hero {
	
	public Warrior() {
		super.level = 1;     
		super.power = 25;    
		super.defense = 25;  
		super.hp = 250;       
		super.mp = 5;  
		
	}
	
	@Override
	public int attack(Monster monster) {
		
 //蓄力斩，释放，额外造成一些伤害
//축력참  발사하여 추가 데미지를 입힐 수 있습니다.
		 System.out.println("당신은 만났 "+ monster.name + "괴물! 전투가 시작됩니다!");
		 System.out.println(name + "의 공격입니다");
		 System.out.println("공격 방식을 선택하세요.1.보통 공격.2.축력참");
		 int attackMethodSelection = scanner.nextInt();
		 
		 if (attackMethodSelection == 1) {
			 harm = level * 10 + power * 25 + mp*15;
			
		 }else if (attackMethodSelection==2) {
				 harm = level * 20 + power * 25 + mp*15;

		 }else {
			 System.out.println("잘못 입력하였습니다. 다시 입력해 주세요");
		 }		                                              
		return harm;
	}
	
}
