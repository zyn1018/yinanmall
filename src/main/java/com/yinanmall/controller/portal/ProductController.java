package com.yinanmall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.yinanmall.common.ServerResponse;
import com.yinanmall.service.IProductService;
import com.yinanmall.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yinan on 6/21/17.
 */
@Controller
@RequestMapping("/product/")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    /*
     * 查询产品的详细信息
     *
     * @param productId
     * @return
     */
    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<ProductDetailVo> detail(Integer productId) {
        return iProductService.getProductDetail(productId);
    }

    /*
     * 查询并列出符合条件的所有产品
     *
     * @param keyword
     * @param categoryId
     * @param pageNum
     * @param pageSize
     * @param orderBy
     * @return
     */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword", required = false) String keyword,
                                         @RequestParam(value = "categoryId", required = false) Integer categoryId,
                                         @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                         @RequestParam(value = "orderBy", defaultValue = "") String orderBy) {
        return iProductService.getProductByKeywordCategory(keyword, categoryId, pageNum, pageSize, orderBy);
    }
}
