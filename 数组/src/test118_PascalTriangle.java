import java.util.ArrayList;
import java.util.List;

/**
 * @author wyd
 * @date 2020/11/4 - 14:05
 */
public class test118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        //首先要知道杨辉三角的形式，一定是大数组套小数组，但是小数组的长度是不固定的。所以需要创建一个不定长的二维数组。
        //首先看List<> triangle = new ArrayList();就是创建了一个triangle集合。
        //再看泛型List<>，就是这个triangle数组中存什么值。那很明显存的应该是那些小数组，所以泛型就是List<>
        //最后看看这个小数组里存放的是什么，很明显是Int类型的数值，那所以，List<Integer>。
        //这里创建完成后，还没有往triangle集合里存放任何数据，所以size=0，triangle=[]
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        //如果生成0行杨辉三角，那直接返回创建的空数组即可。
        if (numRows == 0) {
            return triangle;
        }

        //如果要生成1行或多行杨辉三角
        //new一个数组添加到triangle里，此时triangle的size就变成了1，triangle = [[]]
        triangle.add(new ArrayList<>());
        //triangle.get(0)就是获取0索引的值，也就是[]，然后.add(1)就是给获取到的[]里面添加一个数值1，变成[1]
        //因为杨辉三角的第一个数是1
        triangle.get(0).add(1);

        //第一行已经是1了，从第二行开始
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            //new一个新数组row，这个数组其实就是刚才说的一个个小数组，作用就是最后要往triangle里添加。
            //所以会再每次循环刚开始就创建一个新的row
            List<Integer> row = new ArrayList<>();
            //triangle.get(rowNum-1)就是获取前一个添加进去的数组。因为后面要进行相加运算
            List<Integer> prevRow = triangle.get(rowNum-1);

            //因为从第二行开始往后，小数组中的第一个数一定是1，所以先让row.add(1)
            row.add(1);

            //这个循环的作用是，把刚才说的前一个添加进去的数组prevRow中除去第一个跟最后一个元素之外的元素，
            //每相邻两个进行相加操作，得到的值添加到row数组里。
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            //从第二行开始往后，小数组中的最后一个数一定是1。所以最后再让row.add(1)
            row.add(1);

            //小数组准备完毕。直接添加到triangle这个大数组中即可。这样就完成了一层杨辉三角。
            //当rowNum>=numRows，退出循环，杨辉三角完成。
            triangle.add(row);
        }
        //返回这个杨辉三角
        return triangle;
    }


    public static void main(String[] args) {
        test118_PascalTriangle triangle = new test118_PascalTriangle();
        List<List<Integer>> list = triangle.generate(4);
        System.out.println(list);
    }
}
