public class Card {
	// 处理输入函数 
	void dealInput(String input[],int num[],String decor[]) {
		int i;
		int length;
		String temp;
		for(i = 0;i < 5;i++) {
			length = input[i].length();
			// 长度为2 则1 2 3 4 5 6 7 8 9 J A K A
			if(length == 2) {
				temp = input[i].substring(0, 1);
				switch(temp) {
				case "A":
					num[i] = 14;
					break;
				case "K":
					num[i] = 13;
					break;
				case "Q":
					num[i] = 12;
					break;
				case "J":
					num[i] = 11;
					break;
				default:
					// 直接转化为对应数字
					num[i] = Integer.parseInt(temp);
				}
				decor[i] = input[i].substring(1,2);
			}else if(length == 3) {
				// 长度为3的只有10 特殊处理
				num[i] = 10;
				decor[i] = input[i].substring(2, 3);
			}
		}
	}
	// 输出函数（打印信息）
	String dealOutput(int black,int white,int blacknum,int whitenum) {
		String result = "";
		// 先比较级别
		if(black > white) {
			result = "Black wins";
		}else if(black < white) {
			result = "White wins";
		}else if(black == white) {
			// 级别相同比较最大值
			if(blacknum > whitenum) {
				result = "Black wins";
			}else if(blacknum < whitenum) {
				result = "White wins";
			}else if(blacknum == whitenum) {
				// 级别相同最大值也相同即平局
				result = "Tie";
			}
		}
		return result;
	}
	// 计算牌面对应的级别
	int dealType(int num[],String decor[]) {
		int result = 0;
		// 散牌 - 0 ；对子 - 1； 两对 - 2； 三条 - 3； 顺子 - 4； 同花 - 5； 同花顺 - 6；
		if(dealDuiZi(num)) {
			result = 1;
		}else if(dealLiangDui(num)) {
			result = 2;
		}else if(dealSanTiao(num)) {
			result = 3;
		}else if(dealShunZi(num)) {
			result = 4;
		}else if(dealTongHua(num,decor)) {
			result = 5;
		}else if(dealTongHuaShun(num,decor)) {
			result = 6;
		}else {
			// 散牌 保存散牌中最大的值
			result = 0;
			num[5] = num[4];
		}
		return result;
	}
	// 冒泡排序 将牌面按从小到大排序
	void dealBubble(int num[],String decor[]) {
		int i,j,tempnum;
		String tempdecor;
		for(i = 0;i < 5;i++) {
			for(j = 0;j < 4-i;j++) {
				if(num[j] > num[j+1]) {
					tempnum = num[j+1];
					num[j+1] = num[j];
					num[j] = tempnum;
					tempdecor = decor[j+1];
					decor[j+1] = decor[j];
					decor[j] = tempdecor;
				}
			}
		}
	}
	// 判断是否为同花顺
	boolean dealTongHuaShun(int num[],String decor[]) {
		boolean result = false;
		// 是否为同花
		if(decor[0].equals(decor[1]) && decor[1].equals(decor[2]) && decor[2].equals(decor[3]) && decor[3].equals(decor[4])) {
			// 是否为顺子
			if(num[0] + 1 == num[1] && num[1] + 1 == num[2] && num[2] + 1 == num[3] && num[3] + 1 == num[4]) {
				result = true;
				num[5] = num[4];
			}
		}
		return result;
	}
	// 判断是否为同花
	boolean dealTongHua(int num[],String decor[]) {
		boolean result = false;
		if(decor[0].equals(decor[1]) && decor[1].equals(decor[2]) && decor[2].equals(decor[3]) && decor[3].equals(decor[4])) {
			result = true;
			num[5] = num[4];
		}
		return result;
	}
	// 判断是否为顺子
	boolean dealShunZi(int num[]) {
		boolean result = false;
		if(num[0] + 1 == num[1] && num[1] + 1 == num[2] && num[2] + 1 == num[3] && num[3] + 1 == num[4]) {
			result = true;
			num[5] = num[4];
		}
		return result;
	}
	// 判断是否为三条
	boolean dealSanTiao(int num[]) {
		boolean result = false;
		// 连续三张相同（已经排序）
		if(num[0] == num[1] && num[1] == num[2]) {
			result = true;
			num[5] = num[0];
		}else if(num[1] == num[2] && num[2] == num[3]) {
			result = true;
			num[5] = num[1];
		}else if(num[2] == num[3] && num[3] == num[4]) {
			result = true;
			num[5] = num[2];
		}
		return result;
	}
	// 判断是否为两对
	boolean dealLiangDui(int num[]) {
		boolean result = false;
		// （已经排序）
		if(num[0] == num[1] && num[2] == num[3]) {
			result = true;
			num[5] = num[3];
		}else if(num[1] == num[2] && num[3] == num[4]) {
			result = true;
			num[5] = num[4];
		}
		return result;
	}
	// 判断是否为对子
	boolean dealDuiZi(int num[]) {
		boolean result = false;
		// （已经排序）
		if(num[0] == num[1]) {
			result = true;
			num[5] = num[1];
		}else if(num[1] == num[2]) {
			result = true;
			num[5] = num[2];
		}else if(num[2] == num[3]) {
			result = true;
			num[5] = num[3];
		}else if(num[3] == num[4]) {
			result = true;
			num[5] = num[4];
		}
		return result;
	}
	// 调用返回
	String GetValue(String black[], String white[]) {
		String result = null;								   // 返回结果
		int blacknum[] = new int[] {0,0,0,0,0,0};              // 0-4用来保存黑方的牌值（5用来保存最大值）
		int whitenum[] = new int[] {0,0,0,0,0,0};              // 0-4用来保存白方的牌值（5用来保存最大值）
		String blackdecor[] = new String[] {"","","","",""};   // 用来保存黑方的牌花色
		String whitedecor[] = new String[] {"","","","",""};   // 用来保存白方的牌花色
		int blackRange = 0;								       // 用来保存黑方的级别
		int whiteRange = 0;                                    // 用来保存白方的级别
		// 对输入信息进行处理
		dealInput(black,blacknum,blackdecor);
		dealInput(white,whitenum,whitedecor);
		// 对处理后的数据进行排序
		dealBubble(blacknum,blackdecor);
		dealBubble(whitenum,whitedecor);
		// 找出每副牌最大的级别
		blackRange = dealType(blacknum,blackdecor);
		whiteRange = dealType(whitenum,whitedecor);
		// 比较 输出结果
		result = dealOutput(blackRange,whiteRange,blacknum[5],whitenum[5]);
		return result;
	}
}
