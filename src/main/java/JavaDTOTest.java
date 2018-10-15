import com.example.domain.bean.SimpleDTO;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/23 11:24
 * @Description:
 */
public class JavaDTOTest {

    public static void main(String[] args) {
        SimpleDTO simpleDTO = new SimpleDTO(1, "孙悟空");

        SimpleDTO simpleDTO1 = simpleDTO;
        //插入数据库
        System.out.println(simpleDTO1);

        simpleDTO.setName("猪八戒");
        //插入数据库
        System.out.println(simpleDTO);
        System.out.println(simpleDTO1);
    }

    public void add(SimpleDTO simpleDTO){
        //调用方法A(simpleDTO)
        //调用方法B(simpleDTO)
        //调用方法C(simpleDTO)
    }
}
