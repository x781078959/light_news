import com.gw.dao.LinkDao;
import com.gw.dao.impl.LinkDaoImpl;
import com.gw.pojo.LinkVo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * ClassName: test
 * PackageName: PACKAGE_NAME
 * Description: 测试模块
 *
 * @Author: 谢金宸
 * @Create: 2023.4.26 - 下午 2:28
 * @Version: 1.0
 */
public class test {
    public static void main(String[] args) {
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        String publishDate = dateTimeFormatter.format(now);
//        System.out.println(publishDate);
        LinkDao linkDao = new LinkDaoImpl();
        /**
         * 输出linkdao的结果
         */

    }

}
