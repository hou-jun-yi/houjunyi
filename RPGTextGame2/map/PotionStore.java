package map;

import java.util.Scanner;

import character.Hero;

public class PotionStore { 
	static Scanner scanner = new Scanner(System.in);
	public  void potion(Hero hero) {
		System.out.println("포션상점에 입장하였습니다.");
		System.out.println("1.힘 증강 포션(30원)");
		System.out.println("2.방어력 증강 포션(30원)");
		System.out.println("3.경험치 증강 포션(100원)");
		System.out.println("4.HP 증강 포션(10원)");
		System.out.println("5.MP 증강 포션(10원)");
		System.out.println("구입하신 물약을 선택하세요");
		int num = scanner.nextInt();
		System.out.println("구매한 물약의 수량을 선택하세요");
		int num1 = scanner.nextInt();
		
		
		int potionMoney;
		switch(num) {
		case 1 -> {
			potionMoney = 30;
			
			if(hero.money >= potionMoney*num1) {
				hero.power +=  3 * num1;
				hero.money -= potionMoney*num1;
				System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
				System.out.println("구입 완료되었습니다.");
				
			}else {
                System.out.println("돈이 부족합니다!");
            }
			System.out.println(hero.money + "원 남았습니다");
		}
		case 2 -> {
			potionMoney = 30*num1;
			if(hero.money >= potionMoney) {
				hero.defense +=  3*num1;
				hero.money -= potionMoney;
				System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
				System.out.println("구입 완료되었습니다.");
				
			}else {
                System.out.println("돈이 부족합니다!");
            }
			System.out.println(hero.money + "원 남았습니다");
		}
		case 3 -> {
			potionMoney = 100*num1;
			if(hero.money >= potionMoney) {
				hero.experience += 50*num1;
				hero.money -= potionMoney;
				System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
				System.out.println("구입 완료되었습니다.");
				
			}else {
                System.out.println("돈이 부족합니다!");
            }
			System.out.println(hero.money + "원 남았습니다");
		}
		case 4 -> {
			potionMoney = 10*num1;
			if(hero.money >= potionMoney) {
				hero.hp += 50*num1;
				hero.money -= potionMoney;
				System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
				System.out.println("구입 완료되었습니다.");
				
			}else {
                System.out.println("돈이 부족합니다!");
            }
			System.out.println(hero.money + "원 남았습니다");
		}
		case 5 -> {
			potionMoney = 10*num1;
			if(hero.money >= potionMoney) {
				hero.mp += 50*num1;
				hero.money -= potionMoney;
				System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
				System.out.println("구입 완료되었습니다.");
				
			}else {
                System.out.println("돈이 부족합니다!");
            }
			System.out.println(hero.money + "원 남았습니다");
		}
		default -> System.out.println("잘못 입력하였습니다. 다시 입력해 주세요");
		
		}
	}
}