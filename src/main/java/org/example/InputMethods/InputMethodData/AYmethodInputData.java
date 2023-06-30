package org.example.InputMethods.InputMethodData;

import java.util.HashMap;

import static org.example.InputMethods.CustomStrokeCollections.*;

public class AYmethodInputData {

    public static final HashMap<String, String> arrayInspiredElemsV1 = new HashMap<>();
    static {
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
        arrayInspiredElemsV1.put("𠂇", "zl"); //z=1+9 l=9
        arrayInspiredElemsV1.put("大", "z."); //z=1+8 .=9+8

        // Second column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //w
        arrayInspiredElemsV1.put("女", "wo"); //w=2+1 o=9+1
        arrayInspiredElemsV1.put("巛", "ww"); //w=2+2 w=2+2

        //s
        arrayInspiredElemsV1.put("乙", "ss"); //s=2
        arrayInspiredElemsV1.put(BENTBUTHOOK_LARGE.val(), "ss"); //s=2
        //arrayInputMap.put("几", ""); //s=

        //x
        arrayInspiredElemsV1.put("厶", "xs"); //x=2+6 s=6
        //arrayInputMap.put("風", ""); //
        //arrayInputMap.put("", "");

        //Third column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //e
        arrayInspiredElemsV1.put("門", "et"); //e=3+1 t=5+1
        arrayInspiredElemsV1.put("止", "eq"); //e=3+1 q=1+3
        arrayInspiredElemsV1.put("刂", "ed"); //e=3+3 d=3

        //d
        arrayInspiredElemsV1.put("丨", "dd");
        arrayInspiredElemsV1.put("亅", "dd");
        arrayInspiredElemsV1.put("山", "dw"); //d=3+3 w=2+3
        //arrayInputMap.put("片", "le"); //l=9+5 e=3+1

        //c
        arrayInspiredElemsV1.put("小", "c."); //c=3+8 .=9+8
        arrayInspiredElemsV1.put("龰", "cz"); //c=3+8 z=a+9

        //Forth coulmn
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //r
        arrayInspiredElemsV1.put("土", "ra"); //r=4+1 a=1
        arrayInspiredElemsV1.put("廿", "rd"); //r=4+1 d=3+1

        //f
        arrayInspiredElemsV1.put("十", "ff"); //f=4

        //v
        arrayInspiredElemsV1.put("木", "v."); //v=4+8 .=9+8

        //Fifth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //t
        arrayInspiredElemsV1.put("阝", "td"); //t=5+3 d=3

        //g
        arrayInspiredElemsV1.put("乛", "gg"); //t=5
        arrayInspiredElemsV1.put(BENTTOPHOOK_LARGE.val(), "gg"); //"𠃌" g=5 有万令
        //arrayInputMap.put("", "");

        //b
        arrayInspiredElemsV1.put("刀", "bl"); //b=5+9 l=9

        //Sixth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //y
        arrayInspiredElemsV1.put("言", "yq"); //y=6+1 q=1+1
        arrayInspiredElemsV1.put("讠", "yq"); //言 short
        arrayInspiredElemsV1.put("立", "yz"); //y=6+1 z=1+8

        //h
        arrayInspiredElemsV1.put("丶", "hh"); //h=6  // 兎 ⿱丿⿷⑤丶  匆 ⿻勿丶 ⿹勹⿻⿱丿丿丶
        arrayInspiredElemsV1.put("方", "hz"); //h=6+5 z=1+9

        //n
        arrayInspiredElemsV1.put("之", "nb"); //n=6+8 b=5+8
        arrayInspiredElemsV1.put("心", "nx"); //n=6+6 x=2+6
        arrayInspiredElemsV1.put("辶", "nb"); //n=6+8 g=5+8
        arrayInspiredElemsV1.put("灬", "nn"); //n=6+6 n=6+6

        //Seventh column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //u
        arrayInspiredElemsV1.put("皿", "ue"); //u=7+1 e=3+3
        arrayInspiredElemsV1.put("目", "uq"); //u=0+1  q=1+1

        //j
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
        arrayInspiredElemsV1.put("扌", "oq");
        arrayInspiredElemsV1.put("斤", "oo"); //o=9+3 o=9+1
        arrayInspiredElemsV1.put("臼", "oe"); //o=9+1 e=3+1

        //l
        arrayInspiredElemsV1.put(LEFTSLANT_HORI.val(), "ll"); //l=9 "㇀"
        arrayInspiredElemsV1.put(LEFTSLANT_SHARP.val(), "ll"); //l=9
        arrayInspiredElemsV1.put(LEFTSlANT_VERT.val(), "ll"); //l=9
        arrayInspiredElemsV1.put("几", "lg"); //l=9+5 g=5
        arrayInspiredElemsV1.put("勹", "lg"); //l=9+5 g=5
        //arrayInputMap.put("", "");

        //.
        arrayInspiredElemsV1.put("人", ".k"); //.=9+8 k=8
        arrayInspiredElemsV1.put("亻", ".k"); //short 人
        arrayInspiredElemsV1.put("乂", ".k"); //ex. 文
        arrayInspiredElemsV1.put("𧘇", ".x"); //.=9+8 x=2+9
        //arrayInputMap.put("", "");

        //Tenth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //p
        arrayInspiredElemsV1.put("日", "pa"); //p=0+1 a=1
        arrayInspiredElemsV1.put("田", "pq"); //p=0+4 q=1+3
        arrayInspiredElemsV1.put("罒", "/e"); // /=0+3 e=3+3

        //;
        arrayInspiredElemsV1.put("口", ";;"); //;=0
        arrayInspiredElemsV1.put("囗", ";;"); //;=0

        // /
        arrayInspiredElemsV1.put("四", "/."); // /=0+8 .=9+8
        arrayInspiredElemsV1.put("虫", "/e"); // /=0+6 e=3+1


        //arrayInputMap.put("", "");
        //arrayInputMap.put("", "");
        //arrayInputMap.put("", "");


    }
}
