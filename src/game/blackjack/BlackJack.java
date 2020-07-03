package game.blackjack;

import java.util.Scanner;

public class BlackJack {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		start(scanner);
		scanner.close();
	}

	public static void start(Scanner scanner) {
		Player player = new Player(scanner);
		Dealer dealer = new Dealer();

		Stock stock = new Stock();

//		プレイヤーとディーラーが手札を引く
		player.start(stock);
		dealer.start(stock);

//		ディーラーの手札を表示
		System.out.println(dealer.toString());

//		プレイヤーの手札とアクションを表示、実行
		player.play(stock);

//		プレイヤーがバースト、または、カードを引き終わったらディーラーも手札をそろえ、勝敗を判定
		if(player.calculateStrength() == -1 || player.calculateStrength() > 0) {
			dealer.play(stock);
			showResult(player,dealer);
		}
	}


	public static void showResult(Attender player,Attender dealer) {

//		互いの手札を表示
		System.out.println("==================================================");
		System.out.println("");
		dealer.display();
		player.display();

//		互いの合計値を取得
		int playerInt = player.calculateStrength();
		int dealerInt = dealer.calculateStrength();

		String plmsg = "";
		String dlmsg = "";

		if(playerInt == -1) {
			plmsg = " [バースト]";
		}

		if(dealerInt == 0) {
			dlmsg = " [バースト]";
		}


//		互いの合計値と勝敗の結果を表示
		System.out.println("--------------------------------------------------");
		if(playerInt > dealerInt) {
			System.out.println(player.name + "：" + playerInt + plmsg + "  VS " + dealer.name + "：" + dealerInt + dlmsg);
			System.out.println("あなたの勝ちです！");
		} else if(playerInt == dealerInt) {
			System.out.println(player.name + "：" + playerInt + plmsg + "  VS " + dealer.name + "：" + dealerInt + dlmsg);
			System.out.println("引き分けです！");
		} else {
			System.out.println(player.name + "：" + playerInt + plmsg + "  VS " + dealer.name + "：" + dealerInt + dlmsg);
			System.out.println("あなたの負けです");
		}

	}


}
