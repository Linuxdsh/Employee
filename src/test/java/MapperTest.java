
import com.tang.dao.DepartmentMapper;
import com.tang.dao.EmployeeMapper;
import com.tang.pojo.Department;
import com.tang.pojo.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author tang
 * @create 2021-12-29-14:11
 * Spring的项目就可以使用spring的单元测试，可以自动注入我们需要的组件
 * 1.导入springTest模块
 * 2.@ContextConfiguration指定spring配置文件的位置
 * 3.直接autowired要使用的组件即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    /**
     * 测试department
     */
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void testCRUD(){

//        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Department bean = ioc.getBean(Department.class);

//        System.out.println(departmentMapper);

//        departmentMapper.insertSelective(new Department(null,"开发部"));
//        departmentMapper.insertSelective(new Department(null,"测试部"));

        // 批量添加员工操作
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for(int i=4001;i<5000;i++){
            String name = UUID.randomUUID().toString().substring(0,5) + i;
            mapper.insertSelective( new Employee(null,name,name+"@163.com","M",1));
        }
        System.out.println("批量完成");

        for(int i=3001;i<4000;i++){
            mapper.deleteByPrimaryKey(i);
        }
        System.out.println("删除完成");

    }

}
