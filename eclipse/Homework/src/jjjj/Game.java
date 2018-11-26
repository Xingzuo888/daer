package jjjj;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner; 

public class Game { 
	/** * 1������һ���˿��ư��� 
	 * * ���ֻ�ɫ�����ҡ����ҡ�÷������Ƭ 
	 * * ʮ���ֵ�����2-10��J��Q��K��A�������Ǵ�С�� 
	 * * 2������������� 
	 * * �������Ҫ��ID�����������Ƶ����ԣ�����Ϊ�˿��Ƶļ��� 
	 * * 3��ϴ�� * ��֮ǰ�����ġ�һ���˿��ơ�����˳�� 
	 * * 4����ϴ��֮����˿��Ƽ��ϣ��ӵ�һ�ſ�ʼ������������ң�����һ��һ�ŵķ�ʽ��ÿ�˷����� 
	 * * 5����Ϸ 
	 * * �Ƚ�����������е��˿��ƣ�����ȥ���˸������е��������ƽ��бȽϣ� 
	 * * �������Ӯ�������˸��Եĵ�����������ȣ����ٰ���ɫ�Ƚϣ��ڡ��졢÷�������� 
	 * * */ 
	List<Card> cardToSelect=new ArrayList<Card>();//��������Ƽ��� 
	List<Card> selectedCard=new ArrayList<Card>();//ϴ�ƺ���������Ƽ��� 
	List<Player> playerList=new ArrayList<Player>();//��Ϸ��Ҽ��� 
	Random random=new Random(); int playerNum;//��Ҹ��� 
	int cardNum;//���ӵ�е����� 
	public Game() { } String[] suit= {"����","����","÷��","��Ƭ"}; 
	String[] point= {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	public void cardAdd() { /* * ����˳�����ɵ����Ƽ�����������Ƽ��ϲ���� */ 
		System.out.print("[");
		for(int i=0;i<4;i++) { 
			for(int j=0;j<13;j++) {
				Card card=new Card(suit[i],point[j]);
				cardToSelect.add(card); 
				System.out.print(card);
				}
			}
		System.out.print("]"); /* * ϴ�� */ 
		int k=0;
		int randomIndex; 
		Card randomCard;
		while(k<52) { 
			do { 
				randomIndex=random.nextInt(52);
				randomCard=cardToSelect.get(randomIndex);
				}while(selectedCard.contains(randomCard));//�����ظ������Ƴ��� 
			selectedCard.add(randomCard);
			k++; 
			}
		} 
	public void playerPut() { 
		/* * �������(����ID������) * IDҪ��Ϊ���ͣ��������������û���ʾ���� * ��ʹ��foreach����playerList��Ҽ��ϣ���ӭ��� */ 
		Scanner console=new Scanner(System.in); 
		try { System.out.println("��������Ϸ�����������λ����"); 
		playerNum=console.nextInt(); 
		System.out.println("������ÿλ��ҽ�ӵ�е�������"); 
		cardNum=console.nextInt();
		int i=1;
		while(i<=playerNum) { 
			System.out.println("�������"+i+"λ��ҵ�ID��������");
			System.out.println("����ID��"); 
			int ID=console.nextInt();
			boolean flag=true; 
			for(int j=0;j<playerList.size();j++) { 
				if(playerList.get(j).id==ID) {
					flag=false; 
					System.out.println("��ID�ѱ�ռ��!"); 
					break; 
					}
				}
			if(flag) { 
				System.out.println("����������");
				String name=console.next();
				Player newplayer=new Player(ID,name);
				playerList.add(newplayer); 
				i++;
				}
			}
		}catch(InputMismatchException e) { 
			System.out.println("�������������͵�����!");
			playerPut();
			} 
		for (Player player : playerList) {
			System.out.println("��ӭIDΪ"+player.id+"����ң�"+player.name);
			}
		}
	public void dealCard() { 
		/* * Ϊÿλ��ҷ���Ӧ�����ƣ�һ��һ�ŵطַ� * ��������ÿλ��ҵ����Ƽ���cards�� */ 
		int i=0;
		while(i<cardNum) {
			for(int j=0;j<playerNum;j++) {
				System.out.println("������ң�"+playerList.get(j).name+"������ �õ�����Ϊ��"+selectedCard.get(j+i*playerNum));
				playerList.get(j).cards.add(selectedCard.get(j+i*playerNum)); 
				}
			i++;
			}
		}
	public void playGame() {
		int p[]=new int[cardNum];//��ҵ����Ƶĵ������� 
		int s[]=new int[cardNum];//������ƵĻ�ɫ����
		int maxp[]=new int[playerNum];//�������������Ƶĵ������� 
		int maxs[]=new int[playerNum];//�������������ƵĻ�ɫ����
		List<Card> maxCard=new ArrayList<Card>(); 
		for(int i=0;i<playerNum;i++) { 
			for(int m=0;m<cardNum;m++) { 
				/* * ����ҵĵ�m���Ƶĵ����ͻ�ɫ��������ĵ���point�ͻ�ɫsuit�����е�Ԫ�� 
				 * * �򽫸�Ԫ�ص�����������������Ƶĵ����ͻ�ɫ��������p��s�У���Ϊ�����Ƚϴ�С����Ҫ���� */
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
			/* * Ĭ������������Ϊ��һ������ 
			 * * ����һ���Ʋ�������򽫵�һ���Ƶ��������������������Ƶ����� 
			 * * �ҽ��������������洢���������ͻ�ɫ��������maxp��maxs���Ա�������λ���֮���������ƵĴ�С�Ƚ� */
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
			maxp[i]=p[0];//����ҵ�������Ƶĵ���������ӽ���������������maxp�У��Դ������Ƚ� 
			maxs[i]=s[0];//����ҵ�������ƵĻ�ɫ������ӽ����ɫ��������maxs�У��Դ������Ƚ� 
			System.out.println("��ң�"+playerList.get(i).name+"��������Ϊ��"+maxCard.get(i));
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
		System.out.println("���������������������������"+playerList.get(maxIndex).name+"��ʤ��������������������������");
		System.out.println("�����������������������������Ϊ:"+maxCard.get(maxIndex)+"������������");
		System.out.println("��Ҹ��Ե�����Ϊ��");
		for (int j=0;j<playerNum;j++) { 
			System.out.print(playerList.get(j).name+"������Ϊ:[");
			for(int m=0;m<cardNum;m++) { 
				System.out.print(playerList.get(j).cards.get(m)+" ");
				}
			System.out.println("]");
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		Game game=new Game(); 
		System.out.println("�����������������������������˿��ơ�����������������������"); 
		System.out.println("�����������������������˿��ƴ����ɹ�����������������������"); 
		game.cardAdd(); System.out.println(); 
		System.out.println("��������������������������ʼϴ�ơ�������������������������");
		System.out.println("������������������������ϴ�ƽ�����������������������������"); 
		System.out.println("������������������������������ҡ�������������������������"); 
		game.playerPut();
		System.out.println("��������������������������ʼ���ơ�������������������������");
		game.dealCard(); 
		System.out.println("���������������������������ƽ�����������������������������");
		System.out.println("��������������������������ʼ��Ϸ��������������������������");
		game.playGame(); 
		}

}
