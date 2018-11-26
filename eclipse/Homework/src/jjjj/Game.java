package jjjj;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner; 

public class Game { 
	/** * 1、创建一副扑克牌包括 
	 * * 四种花色：黑桃、红桃、梅花、方片 
	 * * 十三种点数：2-10，J、Q、K、A，不考虑大小王 
	 * * 2、创建两名玩家 
	 * * 玩家至少要有ID、姓名、手牌等属性，手牌为扑克牌的集合 
	 * * 3、洗牌 * 将之前创建的“一副扑克牌”打乱顺序 
	 * * 4、将洗牌之后的扑克牌集合，从第一张开始，发给两名玩家，按照一人一张的方式，每人发两张 
	 * * 5、游戏 
	 * * 比较两名玩家手中的扑克牌，规则：去两人各自手中点数最大的牌进行比较， 
	 * * 点数大的赢；若两人各自的点数最大的牌相等，则再按花色比较（黑、红、梅、方）。 
	 * * */ 
	List<Card> cardToSelect=new ArrayList<Card>();//正序的手牌集合 
	List<Card> selectedCard=new ArrayList<Card>();//洗牌后乱序的手牌集合 
	List<Player> playerList=new ArrayList<Player>();//游戏玩家集合 
	Random random=new Random(); int playerNum;//玩家个数 
	int cardNum;//玩家拥有的牌数 
	public Game() { } String[] suit= {"黑桃","红桃","梅花","方片"}; 
	String[] point= {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	public void cardAdd() { /* * 将按顺序生成的手牌加入正序的手牌集合并输出 */ 
		System.out.print("[");
		for(int i=0;i<4;i++) { 
			for(int j=0;j<13;j++) {
				Card card=new Card(suit[i],point[j]);
				cardToSelect.add(card); 
				System.out.print(card);
				}
			}
		System.out.print("]"); /* * 洗牌 */ 
		int k=0;
		int randomIndex; 
		Card randomCard;
		while(k<52) { 
			do { 
				randomIndex=random.nextInt(52);
				randomCard=cardToSelect.get(randomIndex);
				}while(selectedCard.contains(randomCard));//避免重复的手牌出现 
			selectedCard.add(randomCard);
			k++; 
			}
		} 
	public void playerPut() { 
		/* * 创建玩家(包括ID和姓名) * ID要求为整型，若不符合则向用户提示错误 * 并使用foreach遍历playerList玩家集合，欢迎玩家 */ 
		Scanner console=new Scanner(System.in); 
		try { System.out.println("请输入游戏将创建的玩家位数："); 
		playerNum=console.nextInt(); 
		System.out.println("请输入每位玩家将拥有的牌数："); 
		cardNum=console.nextInt();
		int i=1;
		while(i<=playerNum) { 
			System.out.println("请输入第"+i+"位玩家的ID和姓名：");
			System.out.println("输入ID："); 
			int ID=console.nextInt();
			boolean flag=true; 
			for(int j=0;j<playerList.size();j++) { 
				if(playerList.get(j).id==ID) {
					flag=false; 
					System.out.println("该ID已被占用!"); 
					break; 
					}
				}
			if(flag) { 
				System.out.println("输入姓名：");
				String name=console.next();
				Player newplayer=new Player(ID,name);
				playerList.add(newplayer); 
				i++;
				}
			}
		}catch(InputMismatchException e) { 
			System.out.println("请输入整数类型的数字!");
			playerPut();
			} 
		for (Player player : playerList) {
			System.out.println("欢迎ID为"+player.id+"的玩家："+player.name);
			}
		}
	public void dealCard() { 
		/* * 为每位玩家发相应的手牌，一人一张地分发 * 并储存在每位玩家的手牌集合cards中 */ 
		int i=0;
		while(i<cardNum) {
			for(int j=0;j<playerNum;j++) {
				System.out.println("——玩家："+playerList.get(j).name+"—拿牌 拿到的牌为："+selectedCard.get(j+i*playerNum));
				playerList.get(j).cards.add(selectedCard.get(j+i*playerNum)); 
				}
			i++;
			}
		}
	public void playGame() {
		int p[]=new int[cardNum];//玩家的手牌的点数索引 
		int s[]=new int[cardNum];//玩家手牌的花色索引
		int maxp[]=new int[playerNum];//所有玩家最大手牌的点数索引 
		int maxs[]=new int[playerNum];//所有玩家最大手牌的花色索引
		List<Card> maxCard=new ArrayList<Card>(); 
		for(int i=0;i<playerNum;i++) { 
			for(int m=0;m<cardNum;m++) { 
				/* * 若玩家的第m张牌的点数和花色等于正序的点数point和花色suit数组中的元素 
				 * * 则将该元素的索引储存在玩家手牌的点数和花色索引数组p和s中，其为后续比较大小的重要依据 */
				for(int j=0;j<point.length;j++) { 
					if(playerList.get(i).cards.get(m).point==point[j]) {
						p[m]=j; 
						}
					}
				for(int j=0;j<suit.length;j++) {
					if(playerList.get(i).cards.get(m).suit==suit[j]) {
						s[m]=j; 
						}
					}
				} 
			/* * 默认玩家最大手牌为第一张手牌 
			 * * 若第一张牌不是最大，则将第一张牌的索引换成最大的那张手牌的索引 
			 * * 且将最大的手牌索引存储在最大点数和花色索引数组maxp和maxs中以备后续各位玩家之间的最大手牌的大小比较 */
			int ptemp,stemp; 
			int index=0;
			for(int m=1;m<cardNum;m++) { 
				if(p[0]<p[m]) { 
					index=m; 
					ptemp=p[m];
					p[m]=p[0]; 
					p[0]=ptemp; 
					stemp=s[m];
					s[m]=s[0];
					s[0]=stemp; 
					}
				else if(p[0]==p[m]) {
					if(s[0]<s[m]) { 
						index=m; 
						ptemp=p[m];
						p[m]=p[0];
						p[0]=ptemp;
						stemp=s[m]; 
						s[m]=s[0];
						s[0]=stemp; 
						}
					}
				}
			maxCard.add(playerList.get(i).cards.get(index)); 
			maxp[i]=p[0];//将玩家的最大手牌的点数索引添加进最大点数索引数组maxp中，以待后续比较 
			maxs[i]=s[0];//将玩家的最大手牌的花色索引添加进最大花色索引数组maxs中，以待后续比较 
			System.out.println("玩家："+playerList.get(i).name+"最大的手牌为："+maxCard.get(i));
			} 
		int maxIndex=0; 
		int maxptemp,maxstemp; 
		for(int i=1;i<playerNum;i++) { 
			if(maxp[0]<maxp[i]) { 
				maxIndex=i;
				maxptemp=maxp[i]; 
				maxp[i]=maxp[0];
				maxp[0]=maxptemp; 
				maxstemp=maxs[i];
				maxs[i]=maxs[0];
				maxs[0]=maxstemp; 
				}
			else if(maxp[0]==maxp[i]) {
				if(maxs[0]<maxs[i]) { 
					maxIndex=i;
					maxptemp=maxp[i];
					maxp[i]=maxp[0]; 
					maxp[0]=maxptemp;
					maxstemp=maxs[i]; 
					maxs[i]=maxs[0];
					maxs[0]=maxstemp; 
					}
				}
			}
		System.out.println("————————————玩家"+playerList.get(maxIndex).name+"获胜！————————————");
		System.out.println("——————所有玩家手牌中最大的为:"+maxCard.get(maxIndex)+"——————");
		System.out.println("玩家各自的手牌为：");
		for (int j=0;j<playerNum;j++) { 
			System.out.print(playerList.get(j).name+"的手牌为:[");
			for(int m=0;m<cardNum;m++) { 
				System.out.print(playerList.get(j).cards.get(m)+" ");
				}
			System.out.println("]");
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		Game game=new Game(); 
		System.out.println("————————————创建扑克牌————————————"); 
		System.out.println("———————————扑克牌创建成功———————————"); 
		game.cardAdd(); System.out.println(); 
		System.out.println("————————————开始洗牌—————————————");
		System.out.println("————————————洗牌结束—————————————"); 
		System.out.println("————————————创建玩家—————————————"); 
		game.playerPut();
		System.out.println("————————————开始发牌—————————————");
		game.dealCard(); 
		System.out.println("————————————发牌结束—————————————");
		System.out.println("————————————开始游戏—————————————");
		game.playGame(); 
		}

}
