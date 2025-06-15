package map;

import java.util.Scanner;

import character.Hero;
//购买武器每种武器只能购买一次
public class WeaponStore {
	public static boolean warriorSword = false;
	public static boolean warriorBigSword = false;

	public static boolean archerBow = false;
	public static boolean archerSlingshot = false;

	public static boolean mageTool = false;
	public static boolean magePowerTool = false;
	static Scanner scanner = new Scanner(System.in);
	public  void potion(int heros,Hero hero) {
		
		
		System.out.println("무기상점에 입장하였습니다.");
		switch (heros) {
		case 1->{
			System.out.println("1.대검 무기(40원)");
			System.out.println("2.양손검 무기(80원)");
			Warriorweapons(hero);
		}
		case 2->{
			System.out.println("1.활(50원)");
			System.out.println("2.새총(90원)");
			Archerweapons(hero);
		}
		case 3->{
			System.out.println("1.마법 도구(40원)");
			System.out.println("2.강마법 도구(80원)");
			magicalweapons(hero);
		}
	}
	}
	public static void Warriorweapons(Hero hero){
	    System.out.println("구입하신 무기를 선택하세요.");
	    int num = scanner.nextInt();
	    int WeaponMoney;

	    switch(num) {
	    case 1 -> {
	        if (warriorSword) {
	            System.out.println("이 무기는 구매되었습니다!");
	            break;
	        }
	        WeaponMoney = 40;

	        if (hero.money >= WeaponMoney) {
	            hero.power += 30;
	            hero.mp += 5;
	            hero.money -= WeaponMoney;
	           warriorSword = true;
	            System.out.println("무기를 구매했습니다.");
	        } else {
	            System.out.println("돈이 부족합니다!");
	        }
	        System.out.println(hero.money + "원 남았습니다.");
	    }
	    case 2 -> {
	        if (warriorBigSword) {
	            System.out.println("이 무기는 구매되었습니다!");
	            break;
	        }
	        WeaponMoney = 80;

	        if (hero.money >= WeaponMoney) {
	            hero.power += 60;
	            hero.mp += 10;
	            hero.money -= WeaponMoney;
	            warriorBigSword = true;
	            System.out.println("무기를 구매했습니다.");
	        } else {
	            System.out.println("돈이 부족합니다!");
	        }
	        System.out.println(hero.money + "원 남았습니다.");
	    }
	    default -> System.out.println("잘못 입력하였습니다.");
	    }
	}

	public static void Archerweapons(Hero hero){
	    System.out.println("구입하신 무기를 선택하세요.");
	    int num = scanner.nextInt();
	    int WeaponMoney;

	    switch(num) {
	    case 1 -> {
	        if (archerBow) {
	            System.out.println("이 무기는 구매되었습니다!");
	            break;
	        }
	        WeaponMoney = 50;

	        if (hero.money >= WeaponMoney) {
	            hero.power += 20;
	            hero.mp += 20;
	            hero.money -= WeaponMoney;
	            archerBow = true;
	            System.out.println("무기를 구매했습니다.");
	        } else {
	            System.out.println("돈이 부족합니다!");
	        }
	        System.out.println(hero.money + "원 남았습니다.");
	    }
	    case 2 -> {
	        if (archerSlingshot) {
	            System.out.println("이 무기는 구매되었습니다!");
	            break;
	        }
	        WeaponMoney = 90;

	        if (hero.money >= WeaponMoney) {
	            hero.power += 50;
	            hero.mp += 20;
	            hero.money -= WeaponMoney;
	            archerSlingshot = true;
	            System.out.println("무기를 구매했습니다.");
	        } else {
	            System.out.println("돈이 부족합니다!");
	        }
	        System.out.println(hero.money + "원 남았습니다.");
	    }
	    default -> System.out.println("잘못 입력하였습니다.");
	    }
	}

	public static void magicalweapons(Hero hero){
	    System.out.println("구입하신 무기를 선택하세요.");
	    int num = scanner.nextInt();
	    int WeaponMoney;

	    switch(num) {
	    case 1 -> {
	        if (mageTool) {
	            System.out.println("이 무기는 구매되었습니다!");
	            break;
	        }
	        WeaponMoney = 40;

	        if (hero.money >= WeaponMoney) {
	            hero.power += 15;
	            hero.mp += 20;
	            hero.money -= WeaponMoney;
	            mageTool = true;
	            System.out.println("무기를 구매했습니다.");
	        } else {
	            System.out.println("돈이 부족합니다!");
	        }
	        System.out.println(hero.money + "원 남았습니다.");
	    }
	    case 2 -> {
	        if (magePowerTool) {
	            System.out.println("이 무기는 구매되었습니다!");
	            break;
	        }
	        WeaponMoney = 80;

	        if (hero.money >= WeaponMoney) {
	            hero.power += 30;
	            hero.mp += 40;
	            hero.money -= WeaponMoney;
	            magePowerTool = true;
	            System.out.println("무기를 구매했습니다.");
	        } else {
	            System.out.println("돈이 부족합니다!");
	        }
	        System.out.println(hero.money + "원 남았습니다.");
	    }
	    default -> System.out.println("잘못 입력하였습니다.");
	    }
	}

}
