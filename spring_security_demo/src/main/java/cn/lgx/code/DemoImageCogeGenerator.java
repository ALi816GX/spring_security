package cn.lgx.code;

import cn.lgx.security.core.validate.code.image.ImageCode;
import cn.lgx.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;



//@Component("imageCodeGenerator")
public class DemoImageCogeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生产代码");
        return null;
    }
}
