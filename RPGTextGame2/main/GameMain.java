package main;

import java.util.Scanner;

import character.Hero;
import character.Warrior;
import character.Archer;
import character.Wizard;
import character.Monster;
import character.Paccoon;
import character.WildCat;
import character.WildDog;
import character.WildPig;
import map.PotionStore;
import map.WeaponStore;

public class GameMain {
	static Scanner scanner = new Scanner(System.in);
	static Hero hero;
	static Monster currentMonster;
	
	public static void main(String[] args) {
		System.out.print("이름을 입력해 주세요: ");
		String heroName = scanner.next();
		
		System.out.println("영웅을 선택해 주세요. 1. 전사 2. 궁사 3. 마법사");
		int heroChoice = scanner.nextInt();
		
		// 根据选择创建不同职业的英雄
		//당신의 선택에 따라 다양한 직업의 영웅을 만들어보세요
		switch(heroChoice) {
			case 1 -> {
				 hero = new Warrior();
			
				System.out.println("전사를 선택했습니다!");
			}
			case 2 -> {
				hero = new Archer();
				System.out.println("궁사를 선택했습니다!");
			}
			case 3 -> {
				hero = new Wizard();
				System.out.println("마법사를 선택했습니다!");
			}
			default -> {
				hero = new Hero();
				System.out.println("기본 영웅을 선택했습니다!");
			}
		}
		
		hero.name = heroName;
		System.out.println("이름 입력 완료되었습니다");
		System.out.println("게임에 입장하였습니다");
		System.out.println("*******************");
			
		while(true) {
			// 查看角色面板
			//역할 패널 보기
			displayHeroStatus();
			hero.HeroUpgrade();
			
			System.out.println("들어갈 지역을 선택해 주세요. 1. 사냥터 2. 약물 상점 3. 무기 상점 4. 게임 탈퇴");
			int selection = scanner.nextInt();
			
			switch(selection) {
				case 1 -> {
					battleMonster(heroChoice);
				}
				case 2 -> {
					PotionStore potionStore = new PotionStore();
					potionStore.potion(hero);
				}
				case 3 -> {
					WeaponStore weaponStore = new WeaponStore();  
					weaponStore.potion(heroChoice, hero);
				}
				case 4 -> {
					System.out.println("게임 종료");
					System.exit(0);
				}	
				default -> System.out.println("잘못 입력하였습니다. 다시 입력해 주세요");
			}
		}
	}
	
	// 显示英雄状态
	//영웅 상태 표시
	public static void displayHeroStatus() {
		
		System.out.println("=== 영웅 정보 ===");
		System.out.println("현재 Hero 의 이름: " + hero.name);
		System.out.println("현재 " + hero.name + "의 레벨: " + hero.level);
		System.out.println("현재 " + hero.name + "의 힘: " + hero.power);
		System.out.println("현재 " + hero.name + "의 방어력: " + hero.defense);
		System.out.println("현재 " + hero.name + "의 HP: " + hero.hp);
		System.out.println("현재 " + hero.name + "의 MP: " + hero.mp);
		System.out.println("현재 " + hero.name + "의 경험치: " + hero.experience);
		System.out.println("현재 " + hero.name + "의 돈: " + hero.money);
		System.out.println("================");
	}
	
	// 战斗系统
	//전투 시스템
	public static void battleMonster(int heroChoice) {
		System.out.println("사냥터에 입장하였습니다");
		System.out.println("공격할 대상을 선택하십시오. 1. 너구리 2. 살쾡이 3.들대 4. 맷돼지 ");
		int monsterChoice = scanner.nextInt();

		if (!initializeMonster(monsterChoice)) {
			return; // 如果选择无效，返回主菜单선택이 잘못된 경우 메인 메뉴로 돌아가세요
		}

		System.out.println("전투 시작!");
		
		// 持续战斗直到一方死亡 그들 중 한 명이 죽을 때까지 계속 싸우십시오
		while (hero.hp > 0 && currentMonster.hp > 0) {
			// 英雄攻击回合
			System.out.println("\n=== " + hero.name + "의 턴 ===");
			int heroAttackDamage = hero.attack(currentMonster);
			hero.attacked(heroAttackDamage, currentMonster);
			
			// 检查怪物是否死亡 몬스터가 죽었는지 확인하세요
			if (currentMonster.hp <= 0) {
				break;
			}
			
			// 怪物攻击回合 몬스터 공격 라운드
			System.out.println("\n=== " + currentMonster.name + "의 턴 ===");
			currentMonster.attack(hero);
			currentMonster.attacked(hero);
			
			// 显示当前状态
			System.out.println("\n현재 상태:");
			System.out.println(hero.name + " HP: " + hero.hp);
			System.out.println(currentMonster.name + " HP: " + currentMonster.hp);
			
		}
		
		// 战斗结果处理
		if (hero.hp <= 0) {
			System.out.println("전투에서 패배했습니다!");
			hero.hp = 1; // 复活英雄，HP设为1
			System.out.println("영웅이 부활했습니다! (HP: 1)");
		}

		System.out.println("전투 종료 후 메인 메뉴로 돌아갑니다.");
	}

	// 初始化怪物
	public static boolean initializeMonster(int monsterChoice) {
		switch (monsterChoice) {
			case 1 -> {
				currentMonster = new Paccoon();
				System.out.println("너구리가 나타났습니다!");
				return true;
			}
			case 2 -> {
				if(hero.level>=2) {
					currentMonster = new WildCat();
					System.out.println("살쾡이가 나타났습니다!");
					return true;
				}
				System.out.println("레벨이 너무 낮습니다!");
				return false;
			}
			case 3 ->{
				if(hero.level>=3) {
					currentMonster = new WildDog();
					System.out.println("들개가 나타났습니다!");
					return true;
					
				}
				System.out.println("레벨이 너무 낮습니다!");
				return false;
            }
            case 4->{
            	if(hero.level>=5) {
            	currentMonster = new WildPig();
            	System.out.println("멧돼지가 나타났습니다!");
            	return true;
            	}
            	System.out.println("레벨이 너무 낮습니다!");
				return false;
            }
			default -> {
				System.out.println("잘못 입력하였습니다. 다시 입력해 주세요");
				return false;
			}
		}
	}
}
