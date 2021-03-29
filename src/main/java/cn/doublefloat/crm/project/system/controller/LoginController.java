package cn.doublefloat.crm.project.system.controller;

import cn.doublefloat.crm.framework.security.VerificationCode;
import cn.doublefloat.crm.framework.web.domain.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author RedReins
 * @version 1.0
 * @description: 验证码
 * @date 2021/3/29 8:28
 */
@RestController
public class LoginController {
    /*
     *   注销操作
     * */
    @GetMapping("/loginOut")
    public String doLoginOut() {
        JsonResult ok = JsonResult.success("注销成功!");
        return "ok";
    }
    /*
    *   验证码
    * */
    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
//        得到验证码图片
        BufferedImage image = code.getImage();
//        得到验证码文字
        String text = code.getText();
        HttpSession session = request.getSession(true);
        session.setAttribute("verify_code", text);
        VerificationCode.output(image,resp.getOutputStream());
    }
}
