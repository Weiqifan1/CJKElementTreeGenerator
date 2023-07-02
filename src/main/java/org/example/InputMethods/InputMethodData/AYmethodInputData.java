package org.example.InputMethods.InputMethodData;

import java.util.HashMap;
import java.util.zip.DataFormatException;

import static org.example.InputMethods.CustomStrokeCollections.*;
import static org.example.ObjectTypes.GenericTypes.CJKDescription.OVERLAP;

public class AYmethodInputData {

    public static final HashMap<String, String> arrayInspiredElemsV1 = new HashMap<>();
    static {
        try {
        //theme: I must find a way to distinguis every element below, so they can be written individually.
        //Use a 2-letter system:
        //first letter:
        //use normal array rules => column is decided by first primitive, row by last primitive:
        //(1-4 == top row, 5 == middle row, 6-0 == buttom row).
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //If the elememnt match a primitive, the letter will be from the middle row.
        //second letter:
        //take the element and substract the first primitive. If 2+ strokes are left: then use stroke 1 and 2.
        //if one stroke is left: use the relevant middle-row character.
        //if the element match a primitive, the second letter is the first letter.

        //arrayInputMap.put("", "");
        //First column
        //q
        arrayInspiredElemsV1.put("匕", "qs"); //q=1+2 s=2
        arrayInspiredElemsV1.put("工", "qe"); //q=1+1 e=3+1
        arrayInspiredElemsV1.put("車", "qd"); //q=1+3 d=3+5

        //a
        arrayInspiredElemsV1.put("一", "aa"); //a=1

        //z
        arrayInspiredElemsV1.put("厂", "zl"); //z=1+9 l=9
        arrayInspiredElemsV1.put("𠂆", "zl"); //eg. 所 //alternative form of 厂
        arrayInspiredElemsV1.put("𠂇", "zl"); //z=1+9 l=9
        arrayInspiredElemsV1.put("⺄", "zk"); //z=1+8  k=8    //⺄  eg. 訊
        arrayInspiredElemsV1.put("大", "z."); //z=1+8 .=9+8

        // Second column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //w
        arrayInspiredElemsV1.put("女", "wo"); //w=2+1 o=9+1
        arrayInspiredElemsV1.put("巛", "ww"); //w=2+2 w=2+2

        //s
        arrayInspiredElemsV1.put("乙", "ss"); //s=2
        arrayInspiredElemsV1.put(RIGHTBENTBUTHOOK_LARGE.val(), "ss"); //s=2
        arrayInspiredElemsV1.put(RIGHTBENTBUT_SHARP.val(), "ss"); //s=2
        //arrayInputMap.put("几", ""); //s=

        //x
        arrayInspiredElemsV1.put("厶", "xs"); //x=2+6 s=6
        arrayInspiredElemsV1.put("糸", "xx"); //x=2+8 x=2+6  eg.    //乿	⿰⿱爫糸乚  糸 ⿱幺小  经
        arrayInspiredElemsV1.put("糹", "xx"); //short form of 糸 eg/ 經 ⿰糹巠[GTV]	⿰糸巠[JK]  ⿰纟𢀖
        arrayInspiredElemsV1.put("纟", "xx"); //short form of 纟

        //Third column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //e
        //arrayInspiredElemsV1.put("門", "et"); //e=3+1 t=5+1
        arrayInspiredElemsV1.put("止", "eq"); //e=3+1 q=1+3
        arrayInspiredElemsV1.put("刂", "ed"); //e=3+3 d=3
        //arrayInspiredElemsV1.put(OLAP3ZHABUT.key(), "eq");
        arrayInspiredElemsV1.put(OLAP3ZHABUT.val(), "eq"); //e=3+1  q=1+1 //button of 乍 or left side of 耳
        arrayInspiredElemsV1.put(OLAP4TWOVERTTWOHORI.key(), "eq");//e=3+3 q=1+1 //example: 其 ⿱⿱⑤一八 and 面/囬

        //d
        arrayInspiredElemsV1.put("丨", "dd");
        arrayInspiredElemsV1.put("亅", "dd");
        arrayInspiredElemsV1.put("山", "dw"); //d=3+3 w=2+3
        //arrayInputMap.put("片", "le"); //l=9+5 e=3+1

        //c
        arrayInspiredElemsV1.put("水", "cb"); //c=3+8 b=5+9  //ids: 水	⿲㇇亅⿺乀丿
        arrayInspiredElemsV1.put("氵", "cb"); // 水 short
        arrayInspiredElemsV1.put("小", "c."); //c=3+8 .=9+8
        arrayInspiredElemsV1.put("⺌", "c."); //⺌ variant of 小, from 当
        arrayInspiredElemsV1.put("𭕄", "c."); //variant of 小  //𭕄 eg.  学
        arrayInspiredElemsV1.put("馬", "cq"); //c=3+6  q=1+3  馬 ids ⿹⑥灬

        //Forth coulmn
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //r
        arrayInspiredElemsV1.put("土", "ra"); //r=4+1 a=1
        arrayInspiredElemsV1.put("廿", "rd"); //r=4+1 d=3+1

        //f
        arrayInspiredElemsV1.put("十", "ff"); //f=4
        //arrayInspiredElemsV1.put(OLAP3RUSSIANCROSS.key(), "fq");
        arrayInspiredElemsV1.put(OLAP3RUSSIANCROSS.val(), "fq"); //f=4 q=1+3 //middle side of 生, top side of 龶, top right of 請
        arrayInspiredElemsV1.put(OVERLAP.desc() + "二丨", "fq"); //OLAP3RUSSIANCROSS full value, //middle side of 生, top side of 龶, top right of 請
        //arrayInspiredElemsV1.put(OLAP4NIENBUT.key(), "fq");
        arrayInspiredElemsV1.put(OLAP4NIENBUT.val(), "fq");  //buton side of 年, alternative form of "二丨" //OLAP3RUSSIANCROSS

        //v
        arrayInspiredElemsV1.put("木", "v."); //v=4+8 .=9+8
        arrayInspiredElemsV1.put("𣎳", "v."); //𣎳 v=4+8 .=9+8 Taken as 十 + 八, or an alternative form of 木, eg. 麼

        //Fifth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //t
        arrayInspiredElemsV1.put("阝", "td"); //t=5+3 d=3
        arrayInspiredElemsV1.put("𠁣", "tg"); //t=5+3  q=1+1 𠁣 eg. 門	⿰𠁣𠃛
        arrayInspiredElemsV1.put("𠃛", "tg"); //𠁣 variant //𠃛 eg. 門	⿰𠁣𠃛
        arrayInspiredElemsV1.put(OLAP3HORIFORKLIKE.key(), "tq");
        arrayInspiredElemsV1.put(OLAP3HORIFORKLIKE.val(), "tq"); //t=5+1 q=1+1 eg. 事 stroke 6,7,8 or ids 尹 ⿻⿻コ一丿 stroke 1,2,3
        arrayInspiredElemsV1.put("巳", "tq"); //t=5+2 q=1+2  //巳 from 僊 凞 包

        //g
        arrayInspiredElemsV1.put("乛", "gg"); //t=5
        arrayInspiredElemsV1.put(BENTTOPHOOK_LARGE.val(), "gg"); //"𠃌" g=5 有万令
        arrayInspiredElemsV1.put(BENTTOP_SHARP.val(), "gg"); //𠃍 eg.過
        arrayInspiredElemsV1.put("已", "gg");  //EXCEPTION //已 -- only used in ids character beyond BMP
        arrayInspiredElemsV1.put("弓", "ga"); //g=5+5 a=1+5 //弓 from 發

        //b
        arrayInspiredElemsV1.put("刀", "bl"); //b=5+9 l=9
        arrayInspiredElemsV1.put("又", "bk"); //b=5+8 k=8又 对
        arrayInspiredElemsV1.put("尸", "bz"); //b=5+9 z=1+9  eg. 所
        arrayInspiredElemsV1.put("艮", "bq"); //b=5+8 q=1+1 艮
        arrayInspiredElemsV1.put("己", "bb"); //EXCEPTION  = 己 from //巷	⿱共巳[GTK]	⿱共己[J]
        arrayInspiredElemsV1.put("癶", "b,"); // b=5+8 ,=8+9 //ids 癶 ⿰②③ from 發

        //Sixth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //y
        arrayInspiredElemsV1.put("言", "yq"); //y=6+1 q=1+1
        arrayInspiredElemsV1.put("讠", "yq"); //言 short
        arrayInspiredElemsV1.put("立", "yz"); //y=6+1 z=1+8

        //h
        arrayInspiredElemsV1.put(DOTLEFT.val(), "hh"); //、 eg. 自
        arrayInspiredElemsV1.put(DOTRIGHT.val(), "hh"); //h=6  // 兎 ⿱丿⿷⑤丶  匆 ⿻勿丶 ⿹勹⿻⿱丿丿丶
        arrayInspiredElemsV1.put("方", "hz"); //h=6+5 z=1+9

        //n
        arrayInspiredElemsV1.put("宀", "nd"); //n=6+7 d=3+5    //宀 eg. 家
        arrayInspiredElemsV1.put("之", "nb"); //n=6+8 b=5+8
        arrayInspiredElemsV1.put("辶", "nb"); //n=6+8 g=5+8
        arrayInspiredElemsV1.put("心", "nx"); //n=6+6 x=2+6
        arrayInspiredElemsV1.put("广", "nz"); //n=6+9  z=1+9 eg. 麼
        arrayInspiredElemsV1.put("灬", "nn"); //n=6+6 n=6+6

        //Seventh column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //u
        arrayInspiredElemsV1.put("皿", "ue"); //u=7+1 e=3+3
        arrayInspiredElemsV1.put("目", "uq"); //u=0+1  q=1+1
        arrayInspiredElemsV1.put("巾", "ud"); //u=7+3 d=3  巾 part of rain: eg. 電

        //j
        arrayInspiredElemsV1.put("冖", "jj"); //j=5 冖
        arrayInspiredElemsV1.put(OUTER2TOP_STRAIGHT.val(), "jj"); //j=5 冂 from 向 南
        arrayInspiredElemsV1.put(OUTER2TOP_USEANDMOONE.val(), "jj"); //j=5 ⺆  from 用 周
        //arrayInputMap.put("目", "uq"); u=7+1 q=1+1

        //m
        arrayInspiredElemsV1.put("夕", "mh"); //m=7+6 h=6
        //⿵夙玉 ⿵几⿳一⿴𠂊⺀王
        arrayInspiredElemsV1.put("⿴𠂊⺀", "mn"); //m=7+6 n=6+6x
        arrayInspiredElemsV1.put("貝", "mq"); //m=7+8 q=1+1

        //Eighth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //i
        arrayInspiredElemsV1.put("金", "iq"); //i=8+1 q=1+1    //arrayInputMap.put("半", ""); //i=8+3
        arrayInspiredElemsV1.put("钅", "iq"); //钅simp left-side form of 金
        arrayInspiredElemsV1.put("冫", "ik"); //i=6+1 k=1    ?  資

        //k
        arrayInspiredElemsV1.put("㇂", "kk");
        arrayInspiredElemsV1.put("乀", "kk"); //k=8
        arrayInspiredElemsV1.put("八", "kk"); //k=8
        arrayInspiredElemsV1.put("丷", "kk"); //丷 --八 variation
        //arrayInputMap.put("人", ""); //l=9 k=8
        arrayInspiredElemsV1.put("入", "kl"); //k=8 l=9

        //,
        arrayInspiredElemsV1.put("火", ",."); //,=8+8 .=9+8
        arrayInspiredElemsV1.put("米", ",q"); //,=8+8 q=1+3

        //Nineth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //o
        arrayInspiredElemsV1.put("手", "oq"); //o=9+3 q=1+3 //I take the last 2 strokes to be 1 and 3, not 4
        arrayInspiredElemsV1.put("扌", "oq"); //手 short
        arrayInspiredElemsV1.put("龵", "oq"); //手 variant //龵 eg. 拜	⿰龵⿱一丰  掰 ⿲龵分手[G]  看	⿱龵目
        arrayInspiredElemsV1.put("斤", "oo"); //o=9+3 o=9+1
        arrayInspiredElemsV1.put("彳", "oo"); //o=9+3 0=9+3  彳 eg. 得
        arrayInspiredElemsV1.put("臼", "oe"); //o=9+1 e=3+1
        arrayInspiredElemsV1.put("𦥑", "oe"); //o=9+1 e=3+1

        //l
        arrayInspiredElemsV1.put(LEFTSLANT_HORI.val(), "ll"); //l=9 "㇀"
        arrayInspiredElemsV1.put(LEFTSLANT_SHARP.val(), "ll"); //l=9
        arrayInspiredElemsV1.put(LEFTSlANT_VERT.val(), "ll"); //l=9
        arrayInspiredElemsV1.put("几", "lg"); //l=9+5 g=5  eg. 亢  亮  仉
        arrayInspiredElemsV1.put("𠘧", "lg"); //𠘧  from 没 or 船
        arrayInspiredElemsV1.put("勹", "lg"); //l=9+5 g=5
        //arrayInputMap.put("", "");

        //.
        arrayInspiredElemsV1.put("人", ".k"); //.=9+8 k=8
        arrayInspiredElemsV1.put("亻", ".k"); //short 人
        arrayInspiredElemsV1.put("乂", ".k"); //ex. 文
        arrayInspiredElemsV1.put("㐅", ".k"); //ex. 學
        arrayInspiredElemsV1.put("夂", ".b"); //.=9+9 b=5+8 夂  ex. 後
        arrayInspiredElemsV1.put("夊", ".b"); //.=9+9 b=5+8  夊 eg. 後
        arrayInspiredElemsV1.put("𧘇", ".x"); //.=9+8 x=2+9
        arrayInspiredElemsV1.put("𧰨", ".."); // .=9+8  .=9+9  𧰨 from 家
        //arrayInputMap.put("", "");

        //Tenth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //p
        arrayInspiredElemsV1.put("田", "pq"); //p=0+4 q=1+3
        arrayInspiredElemsV1.put("罒", "pe"); // p=0+3 e=3+3
        arrayInspiredElemsV1.put("甲", "pd"); // p=0+3 d=3 ()  甲 eg. 里

        //;
        arrayInspiredElemsV1.put("日", ";a"); //;=0 a=1
        arrayInspiredElemsV1.put("口", ";;"); //;=0
        arrayInspiredElemsV1.put("囗", ";;"); //;=0

        // /
        arrayInspiredElemsV1.put("四", "/."); // /=0+8 .=9+8
        arrayInspiredElemsV1.put("虫", "/e"); // /=0+6 e=3+1

        //arrayInputMap.put("", "");
        //arrayInputMap.put("", "");
        //arrayInputMap.put("", "");
        } catch (DataFormatException e) {
            throw new RuntimeException(e);
        }

    }
}
