package com.moon.controller;

import com.moon.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")  // 通过这里配置使下面的映射都在/users下
public class UserController {

    // 创建线程安全的Map，模拟 users 信息的存储。
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());


    /**
     * 处理"/users/"的GET请求，用来获取用户列表.
     *
     * @return
     */
    @GetMapping("/")
    public List<User> getUserList() {
        // 还可以通过 @RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<User> userList = new ArrayList<User>(users.values());
        return userList;
    }


    /**
     * 处理 "/users/" 的POST请求，用来创建User.
     *
     * @param user
     * @return
     */
    @PostMapping("/")
    public String postUser(@RequestBody User user) {
        // @RequestBody 注解用来绑定通过 http 请求中 application/json 类型上传的数据。
        users.put(user.getId(), user);
        return "success";
    }


    /**
     * 处理 "/users/{id}"的GET请求，用来获取url中id值的User信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        // url中的id可通过 @PathVariable 绑定到函数的参数中。
        return users.get(id);
    }


    /**
     * 处理 "/users/{id}" 的PUT请求，用来更新User信息.
     *
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/{id}")
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    /**
     * 处理 "/users/{id}" 的DELETE请求，用来删除User。
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }


}
