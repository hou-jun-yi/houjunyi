package HomeWork;

import java.util.Scanner;

public class RPGTextGame {
	static int hero_level = 1;
	static int hero_power = 15;
	static int hero_defense = 25;
	static int hero_hp = 80;
	static int hero_mp = 0;
	static int hero_experience = 0;
	static int hero_money = 0;
	
	static int monster_hp;
	static int monster_defense;
	static int monster_power;
	static int monster_mp;
	static int monster_level;
	static int monster_experience;
	static int monster_money;
	static String hero_name;
	static String monster_name;
	
	static boolean l = false;//判断是否进入药水商店，약수터 입점 여부 판단
	static int harm;//伤害
	
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[]args) {
		
		System.out.print("이름을 입력해 주세요.");
		hero_name = scanner.next();
		System.out.println("이름 입력 완료되었습니다");
		System.out.println("게임에 입장하였습니다");
		System.out.println("*******************");
		
		while(true) {
			//查看角色面板 역할 패널 보기
			System.out.println("현재 Hero 의 이름 :" + hero_name);
			System.out.println("현재"+hero_name+"의 레벨"+hero_level);
			System.out.println("현재"+hero_name+"의 힘"+hero_power);
			System.out.println("현재"+hero_name+"의 방어력"+hero_defense);
			System.out.println("현재"+hero_name+"의 HP"+hero_hp);
			System.out.println("현재"+hero_name+"의 경험치"+hero_experience );
			System.out.println("현재"+hero_name+"의 돈"+hero_money);
			
			System.out.println("들어갈 지역을 선택해 주세요. 1. 사냥터. 2.약방. 3. 게임 탈퇴");
			int Selection = scanner.nextInt();
			switch(Selection) {
			case 1 -> {
				battleMonster();
			
			}
				
			case 2 -> {
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
				potionStore(hero_money,num,num1);
				
			}
			case 3 -> {
				System.out.println("게임 종료");
				System.exit(0);
			}	
				
			default -> System.out.println("잘못 입력하였습니다. 다시 입력해 주세요");
			
			}
		}
	
	}
		//战斗系统 전투 
	public static void battleMonster() {
        System.out.println("사냥터 입성하였습니다");
        System.out.println("공격할 대상을 선택하십시오. 1.너구리. 2. 살쾡이");
        int Monster = scanner.nextInt();

        boolean validMonster = initializeMonster(Monster);
        if (!validMonster) return;

        // 持续战斗直到一方死亡
        while (hero_hp > 0 && monster_hp > 0) {
            Hero_attack();
            Hero_attacked();
            if (monster_hp <= 0) break;   
            monster_attack();
            monster_attacked();
        }
        if(hero_hp <= 0) {
        	hero_hp = 1;
        }

        System.out.println("전투 종료 후 메인 메뉴로 돌아갑니다.");
        
    }

    // 初始化怪物 초시화 괴물
    public static boolean initializeMonster(int Monster) {
        switch (Monster) {
            case 1 -> {
                monster_name = "너구리";
                monster_hp = 100;
                monster_defense = 5;
                monster_power = 20;
                monster_mp = 0;
                monster_level = 1;
                monster_experience = 10;
                monster_money = 10;
                return true;
            }
            case 2 -> {
                if (l) {
                    monster_name = "살쾡이";
                    monster_hp = 2000;
                    monster_defense = 20;
                    monster_power = 100;
                    monster_mp = 5;
                    monster_level = 5;
                    monster_experience = 50;
                    monster_money = 30;
                    return true;
                } else {
                    System.out.println("몬스터 추가로 등장한 살쾡이 공격에 필요한 포션을 구입할 상점 필요");
                    return false;
                }
            }
            default -> {
                System.out.println("잘못 입력하였습니다. 다시 입력해 주세요");
                return false;
            }
        }
    }
		//玩家攻击伤害 플레이어 공격 상해
		public static void Hero_attack() {
			 System.out.println("당신은 만났 "+ monster_name + "괴물! 전투가 시작됩니다!");
			 
			 System.out.println(hero_name + "의 공격입니다");
			 harm = hero_level * 10 + hero_power * 30;
			 System.out.println(monster_name + "데미지는" + harm +"입니다");
			if (harm >=  monster_defense) {
				 monster_hp = monster_hp + monster_defense - harm;
			} else {
				System.out.println(monster_name + "방어력이 너무 높아서 해롭지 않습니다.");
			}
		}		
			
			
		//判断怪物是否死亡，并获得奖励 괴물의 사망 여부 판단, 포상금 지급
		public static void Hero_attacked() {
			 if( monster_hp <= 0) {
				 System.out.println(monster_name +  "가 죽었습니다");
				 hero_experience += monster_experience;
				 hero_money += monster_money;
				 HeroUpgrade();
				
			}
		}	 
		//怪物攻击 괴물 공격
		public static void monster_attack() {
			System.out.println(monster_name + "를 공격합니다");
			if(hero_defense >=  monster_power) {
				System.out.println(hero_name + "다치지 않았습니다!");
			}else{
				hero_hp = hero_hp + hero_defense - monster_power;
				System.out.println(hero_name + "받았" +monster_power + "데미지 찍기!");	
			}
		}
		//判断英雄死亡 판단 영웅 사망
		public static void monster_attacked() {
			if( hero_hp <= 0) {
				System.out.println("히어로가 죽었습니다");	 
				System.out.println("히어로가 부활했습니다");
				
			
			}
		}			
				 
		//英雄升级 영웅의 진급
		public static void HeroUpgrade() {
			if (hero_experience >= hero_level * 80) {
				hero_level += 1;
				System.out.println("레벨을 증가했습니다");
				hero_money += hero_level * 50;
				System.out.println("“레밸업 기념으로 돈이 증가했습니다");
				hero_experience = 0;
			}
		}
		//药水商店购买商品 물약가게에서 상품을 구매합니다.
		public static void potionStore(int money,int num,int num1) {
			int potionMoney;
			switch(num) {
			case 1 -> {
				potionMoney = 30;
				
				if(money >= potionMoney*num1) {
					hero_power +=  3 * num1;
					hero_money -= potionMoney*num1;
					System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
					System.out.println("구입 완료되었습니다.");
					l = true;
				}else {
	                System.out.println("돈이 부족합니다!");
	            }
				System.out.println(hero_money + "원 남았습니다");
			}
			case 2 -> {
				potionMoney = 30*num1;
				if(money >= potionMoney) {
					hero_defense +=  3*num1;
					hero_money -= potionMoney;
					System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
					System.out.println("구입 완료되었습니다.");
					l = true;
				}else {
	                System.out.println("돈이 부족합니다!");
	            }
				System.out.println(hero_money + "원 남았습니다");
			}
			case 3 -> {
				potionMoney = 100*num1;
				if(money >= potionMoney) {
					hero_experience += 50*num1;
					hero_money -= potionMoney;
					System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
					System.out.println("구입 완료되었습니다.");
					l = true;
				}else {
	                System.out.println("돈이 부족합니다!");
	            }
				System.out.println(hero_money + "원 남았습니다");
			}
			case 4 -> {
				potionMoney = 10*num1;
				if(money >= potionMoney) {
					hero_hp += 50*num1;
					hero_money -= potionMoney;
					System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
					System.out.println("구입 완료되었습니다.");
					l = true;
				}else {
	                System.out.println("돈이 부족합니다!");
	            }
				System.out.println(hero_money + "원 남았습니다");
			}
			case 5 -> {
				potionMoney = 10*num1;
				if(money >= potionMoney) {
					hero_mp += 50*num1;
					hero_money -= potionMoney;
					System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
					System.out.println("구입 완료되었습니다.");
					l = true;
				}else {
	                System.out.println("돈이 부족합니다!");
	            }
				System.out.println(hero_money + "원 남았습니다");
			}
			default -> System.out.println("잘못 입력하였습니다. 다시 입력해 주세요");
			}
		}	
}
