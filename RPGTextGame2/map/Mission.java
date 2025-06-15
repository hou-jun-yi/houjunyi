package map;

import java.util.Scanner;
import character.Hero;
import character.Monster;
import character.WildCat;
import character.Paccoon;
import character.WildDog;
import character.WildPig;

public class Mission {

    static Scanner scanner = new Scanner(System.in);
   
    // 任务完成状态数组，用来记录每个等级的任务是否完成
  //작업 완료 상태 배열, 각 작업 레벨이 완료되었는지 기록하는 데 사용됨
    public static boolean[] levelMissionCompleted = new boolean[10];
    
     //检查等级提升时是否有新任务    
 // 레벨이 증가할 때 새로운 작업이 있는지 확인
    public static void checkLevelUpMission(Hero hero) {
        int currentLevel = hero.level;
        // 检查：1.等级不超过数组长度 2.该等级的任务还没有完成
     // 확인 : 1. 레벨이 배열의 길이를 초과하지 않음 2. 이 레벨의 작업이 완료되지 않음
        if (currentLevel <= levelMissionCompleted.length && 
            levelMissionCompleted[currentLevel - 1] == false) {
            
            System.out.println("-------------------------");
            System.out.println(" 레벨 " + currentLevel + " 달성! 새로운 미션이 있습니다!");
            // 根据等级分配相应的任务
         // 레벨에 따라 작업 할당
            assignMission(hero, currentLevel);
        }
    }
    //根据等级分配任
    public static void assignMission(Hero hero, int level) {
        // 根据等级选择不同的任务
    	// 레벨에 따라 다른 작업을 선택하세요
        if (level == 2) {
            mission_Level2(hero);  
        } else if (level == 3) {
            mission_Level3(hero); 
        } else if (level == 5) {
            mission_Level5(hero);  
        } else if (level == 7) {
            mission_Level7(hero);  
        } else if (level == 10) {
            mission_Level10(hero); 
        } 
    }
    public static void mission_Level2(Hero hero) {
        System.out.println("레벨 2 미션 첫 번째 도전");
        System.out.println("너구리 1마리 처치하기");
        System.out.println("경험치 +20, 골드 +50");
  
            Paccoon raccoon = new Paccoon();
            // 执行战斗任务：击败1只浣熊，奖励经验值20，金币50，任务等级2
         // 전투 임무 수행: 너구리 1마리 처치, 보상으로 경험치 20점, 금화 50개, 임무 레벨 2
            performBattleMission(hero, raccoon, 1, 20, 50, 2);
        
    }

    public static void mission_Level3(Hero hero) {
        System.out.println("레벨 3 미션 실력을 증명하라");
        System.out.println("살쾡이 1마리 처치하기");
        System.out.println("경험치 +30, 골드 +80, 힘 +5");

            WildCat wildcat = new WildCat();
            // 执行带属性奖励的战斗任务
          //속성 보상을 획득하여 전투 임무 수행
            performBattleMissionWithStat(hero, wildcat, 1, 30, 80, 3, "power", 5);
    }
    //5级任务：중급자의 시험 (中级者的考验)
  //레벨 5 미션: 중급 레벨러의 시험
  
    public static void mission_Level5(Hero hero) {
        System.out.println("레벨 5 미션 중급자의 시험");
        System.out.println("들개 1마리 처치하기");
        System.out.println("경험치 +50, 골드 +120, 방어력 +8");

            WildDog wilddog = new WildDog();
            // 执行战斗任务，奖励防御力
         // 전투 임무를 수행하고 방어에 대한 보상을 제공합니다.
            performBattleMissionWithStat(hero, wilddog, 1, 50, 120, 5, "defense", 8);
    }
    
    public static void mission_Level7(Hero hero) {
        System.out.println("레벨 7 미션 연속 전투의 달인");
        System.out.println("너구리 2마리 + 살쾡이 1마리 처치하기");
        System.out.println("경험치 +80, 골드 +200, HP +30, MP +20");
       
            performCombinedMission(hero);
    }
    
    public static void mission_Level10(Hero hero) {
        System.out.println("레벨 10 미션고수의 증명");
        System.out.println("멧돼지 1마리 처치하기");
        System.out.println("경험치 +100, 골드 +300, 모든 스탯 +10");

            // 执行终极任务
            performUltimateMission(hero);
        }
    
    

//     执行基本战斗任务기본 전투 임무 수행
//hero 英雄对象영웅 객체
//monster 怪物对象몬스터 오브젝트
//count 需要击败的怪物数量 물리쳐야 할 몬스터의 수
//expReward 经验值奖励경험치 보상
//goldReward 金币奖励 골드 코인 리워드
//missionLevel 任务等级작업 수준
     
    public static void performBattleMission(Hero hero, Monster monster, int count, 
                                           int expReward, int goldReward, int missionLevel) {
        System.out.println("전투 시작!");
        
        
        boolean success = true;
        
        for (int i = 0; i < count; i++) {
            System.out.println("\n--- " + (i + 1) + "번째 전투 ---");
            
            
            int heroAttack = hero.attack(monster);
           
            hero.attacked(heroAttack, monster);
            
     
            if (hero.hp <= 0) {
                success = false;
                break; 
            }
        }
        
        // 根据战斗结果给予奖励或提示失败
     // 전투 결과에 따라 보상을 주거나 실패를 유도합니다.
        if (success == true) {
            completeMission(hero, expReward, goldReward, missionLevel);
        } else {
            System.out.println("미션 실패! 다시 도전해보세요.");
        }
    }
    

	//执行带属性奖励的战斗任务
	//hero 英雄对象
	//monster 怪物对象
	//count 需要击败的怪物数量
	//expReward 经验值奖励
	//goldReward 金币奖励
	//missionLevel 任务等级
	//statType 属性类型 ("power", "defense", "hp", "mp")
	//statValue 属性增加值
   
    public static void performBattleMissionWithStat(Hero hero, Monster monster, int count, 
                                                   int expReward, int goldReward, int missionLevel,
                                                   String statType, int statValue) {
        System.out.println("전투 시작!");
        
        boolean success = true;
        
        // 进行战斗
        for (int i = 0; i < count; i++) {
            System.out.println("\n--- " + (i + 1) + "번째 전투 ---");
            
            int heroAttack = hero.attack(monster);
            hero.attacked(heroAttack, monster);
            
            if (hero.hp <= 0) {
                success = false;
                break;
            }
        }
        
        if (success == true) {
            // 根据属性类型增加相应的属性
        	// 속성 유형에 따라 해당 속성을 추가합니다.
            if (statType.equals("power")) {
                hero.power = hero.power + statValue;
            } else if (statType.equals("defense")) {
                hero.defense = hero.defense + statValue;
            } else if (statType.equals("hp")) {
                hero.hp = hero.hp + statValue;
            } else if (statType.equals("mp")) {
                hero.mp = hero.mp + statValue;
            }
            
            // 完成任务并显示额外奖励
         // 작업을 완료하고 추가 보상을 표시합니다.
            completeMission(hero, expReward, goldReward, missionLevel);
            System.out.println("추가 보상: " + statType + " +" + statValue);
        } else {
            System.out.println("미션 실패! 다시 도전해보세요.");
        }
    }
//7级
    public static void performCombinedMission(Hero hero) {
        System.out.println("연속 전투 시작!");
        
        boolean success = true;
        
        // 第一阶段：击败2只浣熊
     // 1단계: 너구리 2마리 처치
        for (int i = 0; i < 2; i++) {
            System.out.println("\n--- 너구리와의 전투 " + (i + 1) + " ---");
            
            // 创建新的浣熊对象（每次战斗都是新的怪物）
         // 새로운 너구리 객체를 생성합니다(각 전투마다 새로운 몬스터)
            Paccoon raccoon = new Paccoon();
            int heroAttack = hero.attack(raccoon);
            hero.attacked(heroAttack, raccoon);
            
            // 检查英雄是否死亡
            if (hero.hp <= 0) {
                success = false;
                break;
            }
        }
        
        // 第二阶段：击败1只野猫（只有第一阶段成功才进行）
     // 2단계: 야생 고양이 1마리 처치 (1단계가 성공한 경우에만 해당)
        if (success == true) {
            System.out.println("\n--- 살쾡이와의 전투 ---");
            
            WildCat wildcat = new WildCat();
            int heroAttack = hero.attack(wildcat);
            hero.attacked(heroAttack, wildcat);
            
            if (hero.hp <= 0) {
                success = false;
            }
        }
        
       
        if (success == true) {
          
            hero.hp = hero.hp + 30;
            hero.mp = hero.mp + 20;
            
          
            completeMission(hero, 80, 200, 7);
            System.out.println("추가 보상: HP +30, MP +20");
        } else {
            System.out.println("미션 실패! 다시 도전해보세요.");
        }
    }
     //执行终极任务 (10级任务)
  //최종 미션 수행 (레벨 10 미션)
    public static void performUltimateMission(Hero hero) {
        System.out.println("궁극의 전투 시작!");

        WildPig wildpig = new WildPig();
        int heroAttack = hero.attack(wildpig);
        hero.attacked(heroAttack, wildpig);
        
    
        if (hero.hp > 0) {
            // 任务成功：增加所有属性
        	// 미션 성공: 모든 속성 증가
            hero.power = hero.power + 10;
            hero.defense = hero.defense + 10;
            hero.hp = hero.hp + 10;
            hero.mp = hero.mp + 10;
            
            // 完成任务
            completeMission(hero, 100, 300, 10);
            System.out.println("추가 보상: 모든 스탯 +10");
        } else {
            System.out.println("미션 실패! 다시 도전해보세요.");
        }
    }
    

//完成任务的处理
//给予奖励并更新任务状态
//hero 英雄对象
//expReward 经验值奖励
//goldReward 金币奖励
//missionLevel 任务等级
   public static void completeMission(Hero hero, int expReward, int goldReward, int missionLevel) {
        System.out.println("미션 완료!");
        System.out.println("=========================");
        
        System.out.println(" 경험치: +" + expReward);
        System.out.println(" 골드: +" + goldReward);
        
        // 给英雄增加经验值和金币
      //영웅에게 경험치와 금화를 추가합니다.
        hero.experience = hero.experience + expReward;
        hero.money = hero.money + goldReward;
        
        // 标记该等级的任务为已完成
     // 이 레벨의 작업을 완료된 것으로 표시합니다.
        if (missionLevel <= levelMissionCompleted.length) {
            levelMissionCompleted[missionLevel - 1] = true;
        }
       // 检查是否因为获得经验值而再次升级
     // 획득한 경험치로 인해 다시 레벨업 되었는지 확인
        hero.HeroUpgrade();
    }     
}