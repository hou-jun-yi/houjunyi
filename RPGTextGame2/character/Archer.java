package character;

//射手궁사
public class Archer extends Hero{
	public Archer() {
		
		super.level = 1;     
		super.power = 20;    
		super.defense = 25;  
		super.hp = 180;       
		super.mp = 10; 
		
					
	}

	public int attack(Monster monster) {
		
	
		
	
		
		 System.out.println("당신은 만났 "+ monster.name + "괴물! 전투가 시작됩니다!");
		 System.out.println(name + "의 공격입니다");
		 System.out.println("공격 방식을 선택하세요.1.보통 공격.2.축력 공격");
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
