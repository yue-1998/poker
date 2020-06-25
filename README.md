扑克：

说明：

大小顺序： 2<3<4<5<6<7<8<9<10<J<Q<K<A
对应关系：
	A - 14
	K - 13
	Q - 12
	J - 11
	其余不变

主要思想：将输入的牌面分离出牌面大小和花色，判断一副牌的最大级别（同花顺/同花/顺子/三条/两对/对子/散排）并找出此级别中对应最大的牌
		先比较级别，若级别相同再比较级别中最大的牌值即可得出结果。
		
程序说明：

	Card.java：实现比较的程序，包含以下方法：
	
		void dealInput(String input[],int num[],String decor[])；
		
			无返回值类型；
			
			主要功能：对输入的牌值进行一定的处理，将字符串转为数字（A-14,K-13,Q-12,J-11,）;
			
			input[]：输入的字符串数组；
			
			num[]：分离出的数字（牌面大小）；
			
			decor[]:分离出的花色；（顺序与牌大小对应）
		
		String dealOutput(int black,int white,int blacknum,int whitenum)；
		
			返回值为字符串，共三种:Black wins/White wins/Tie;
			
			主要功能：返回比较结果
			
			black:黑方牌面的级别
			
			white：白方牌面的级别
			
			blacknum：黑方牌面级别里最大的牌值
			
			whitenum：白方牌面界别里最大的牌值
			
		int dealType(int num[],String decor[])；
		
			返回值类型为整数：
			
				0 - 散排
				1 - 对子
				2 - 两对
				3 - 三条
				4 - 顺子
				5 - 同花
				6 - 同花顺
				
			主要功能：经过判断找出一副牌对应的最大级别（以数字表示）
			
			num[]:牌值
			
			decor[]:牌花色
			
		void dealBubble(int num[],String decor[])；
		
			无返回类型；
			
			主要功能：对输入的5张牌进行原地从小到大排序排序
			
			num:牌值
			
			decor:牌花色
			
			注：排序移动过程中，大小与花色一起移动
			
		boolean dealTongHuaShun(int num[],String decor[])；
		
			返回类型bool：
				false：非同花顺
				true：是同花顺
				
			主要功能：判断一副牌是否是同花顺
			
			num[]:牌值
			
			decor[]:牌花色
			
		boolean dealTongHua(int num[],String decor[])；
		
			返回类型bool：
				false：非花顺
				true：是花顺
				
			主要功能：判断一副牌是否是花顺
			
			num[]:牌值
			
			decor[]:牌花色
			
		boolean dealShunZi(int num[])；
		
			返回类型bool：
				false：非顺子
				true：是顺子
				
			主要功能：判断一副牌是否是顺子
			
			num[]:牌值
			
			decor[]:牌花色
			
		boolean dealSanTiao(int num[])；
		
			返回类型bool：
				false：非三条
				true：是三条
				
			主要功能：判断一副牌是否是三条
			
			num[]:牌值
			
			decor[]:牌花色
		boolean dealLiangDui(int num[])；
		
			返回类型bool：
				false：非两对
				true：是两对
				
			主要功能：判断一副牌是否是两对
			
			num[]:牌值
			
			decor[]:牌花色
			
		boolean dealDuiZi(int num[])；
		
			返回类型bool：
				false：非对子
				true：是对子
				
			主要功能：判断一副牌是否是对子
			
			num[]:牌值
			
			decor[]:牌花色
			
		String GetValue(String black[], String white[])；
		
			返回值为字符串
			
			主要功能：相当于main函数
			
			black:原始黑方牌面
			
			white:原始白方牌面
			
	TestCard.java：测试程序，包含5个测试用例
	
