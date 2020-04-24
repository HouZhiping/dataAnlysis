package com.village.dataAnlysis.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.village.dataAnlysis.domain.entity.OrderEntity;
import com.village.dataAnlysis.domain.entity.OrderEntityVo;
import com.village.dataAnlysis.response.BaseResponse;
import com.village.dataAnlysis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 'longqiao_info.an_ren_kou_shu_tong_ji_jia_ting_shu_view' is not BASE TABLE 前端控制器
 * </p>
 *
 * @author houzhiping
 * @since 2019-10-25
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {


    @Autowired
    private OrderService orderServiceImpl;

    /**
     * 根据id获取订单信息
     * @param pageNo
     * @param pageSize
     * @param orderEntity
     * @return
     */
    @PostMapping("/getOrderById")
    public BaseResponse getOrderById(
            @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize, OrderEntity orderEntity) {

        OrderEntity orderEntity1 = orderServiceImpl.getById(orderEntity.getId());

        BaseResponse baseResponse = new BaseResponse<>(true,"查询成功",orderEntity1);

        return baseResponse;
    }

    /**
     * 新增订单
     * @param orderEntity
     * @return
     */
    @PostMapping("/addOrder")
    public BaseResponse addOrder(OrderEntity orderEntity) {

        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        try {
            Boolean ok = orderServiceImpl.save(orderEntity);
            baseResponse.setSuccess(ok);
        }catch (Exception e){
            e.printStackTrace();
            baseResponse.setSuccess(false);
        }

        return baseResponse;
    }


    @RequestMapping("/page")
    public BaseResponse page(OrderEntityVo orderEntity) {

        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);

        Page<OrderEntity> page = new Page();
        page.setCurrent(orderEntity.getCurrent());//当前页
        page.setSize(orderEntity.getSize());//当前页多少条数据

        QueryWrapper<OrderEntity> queryWrapper = new QueryWrapper<>();
        String vagueCode = orderEntity.getVagueCode();
        if(vagueCode != null){
            queryWrapper.like("orderCode",vagueCode).or().like("customerName",vagueCode);
        }


        IPage<OrderEntity> page1 = orderServiceImpl.page(page, queryWrapper);

        baseResponse.setData(page1);
        return baseResponse;
    }

    @RequestMapping("/save")
    @ResponseBody
    public BaseResponse save( OrderEntity orderEntity) {

        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMsg("新增订单成功");

        try {
            orderServiceImpl.save(orderEntity);
        }catch (Exception e){
            e.printStackTrace();
            baseResponse.setMsg("新增订单失败");
            baseResponse.setSuccess(false);
        }


        return baseResponse;
    }
    @RequestMapping("/delOrderById")
    @ResponseBody
    public BaseResponse delOrderById( OrderEntity orderEntity) {

        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMsg("删除订单成功");

        try {
            orderServiceImpl.removeById(orderEntity.getId());
        }catch (Exception e){
            e.printStackTrace();
            baseResponse.setMsg("删除订单失败");
            baseResponse.setSuccess(false);
        }


        return baseResponse;
    }

    @RequestMapping("/updateById")
    @ResponseBody
    public BaseResponse updateById( OrderEntity orderEntity) {

        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMsg("更新订单成功");

        try {
            orderServiceImpl.updateById(orderEntity);
        }catch (Exception e){
            e.printStackTrace();
            baseResponse.setMsg("更新订单失败");
            baseResponse.setSuccess(false);
        }

        return baseResponse;
    }







}
