package com.village.dataAnlysis.controller.order;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.village.dataAnlysis.domain.entity.order.ComponentEntity;
import com.village.dataAnlysis.domain.entity.order.ComponentEntityVo;
import com.village.dataAnlysis.response.BaseResponse;
import com.village.dataAnlysis.service.order.ComponentService;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/order/component")
public class ComponentController {

    @Autowired
    private ComponentService componentServiceImpl;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RequestMapping("/test")
    @ResponseBody
    public BaseResponse test(ComponentEntity componentEntity) throws Exception{

        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);

        stringRedisTemplate.opsForValue().set("aaa", componentEntity.getType());


//        cpu();


        return baseResponse;
    }

    @RequestMapping("/test1")
    @ResponseBody
    public BaseResponse test1(ComponentEntity componentEntity) throws Exception{

        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);

        String a = stringRedisTemplate.opsForValue().get("aaa");

        baseResponse.setData(a);

        return baseResponse;
    }




    @RequestMapping("/page")
    public BaseResponse page(ComponentEntityVo componentEntityVo) {

        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);

        Integer orderId = componentEntityVo.getOrderId();
        if(orderId == null){
            baseResponse.setSuccess(false);
            baseResponse.setMsg("订单Id有误！");
            return baseResponse;
        }

        Page<ComponentEntity> page = new Page();
        page.setCurrent(componentEntityVo.getCurrent());//当前页
        page.setSize(componentEntityVo.getSize());//当前页多少条数据

        QueryWrapper<ComponentEntity> queryWrapper = new QueryWrapper<>();
        String vagueCode = componentEntityVo.getVagueCode();
        queryWrapper.eq("orderId",orderId);
        if(vagueCode != null){
            queryWrapper.like("orderCode",vagueCode).or().like("customerName",vagueCode);
        }

        IPage<ComponentEntity> page1 = componentServiceImpl.page(page, queryWrapper);

        baseResponse.setData(page1);

        return baseResponse;
    }

    @RequestMapping("/save")
    @ResponseBody
    public BaseResponse save(ComponentEntity componentEntity) {

        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMsg("新增订单物料成功");

        try {
            componentServiceImpl.save(componentEntity);
        }catch (Exception e){
            e.printStackTrace();
            baseResponse.setMsg("新增订单物料失败");
            baseResponse.setSuccess(false);
        }


        return baseResponse;
    }

    @RequestMapping("/delById")
    @ResponseBody
    public BaseResponse delOrderById(ComponentEntity componentEntity) {

        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMsg("删除订单物料成功");

        try {
            componentServiceImpl.removeById(componentEntity.getId());
        }catch (Exception e){
            e.printStackTrace();
            baseResponse.setMsg("删除订单物料失败");
            baseResponse.setSuccess(false);
        }


        return baseResponse;
    }


    @RequestMapping("/updateById")
    @ResponseBody
    public BaseResponse updateById(ComponentEntity componentEntity) {

        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMsg("更新物料成功");

        try {
            componentServiceImpl.updateById(componentEntity);
        }catch (Exception e){
            e.printStackTrace();
            baseResponse.setMsg("更新订单物料失败");
            baseResponse.setSuccess(false);
        }

        return baseResponse;
    }

    private void cpu() throws SigarException {
        Sigar sigar = new Sigar();
        CpuInfo infos[] = sigar.getCpuInfoList();
        CpuPerc cpuList[] = null;
        cpuList = sigar.getCpuPercList();
        for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
            CpuInfo info = infos[i];
            System.out.println("################################################################################第" + (i + 1) + "块CPU信息");
            System.out.println("CPU的总量MHz:    " + info.getMhz());// CPU的总量MHz
            System.out.println("CPU生产商:    " + info.getVendor());// 获得CPU的卖主，如：Intel
            System.out.println("CPU类别:    " + info.getModel());// 获得CPU的类别，如：Celeron
            System.out.println("CPU缓存数量:    " + info.getCacheSize());// 缓冲存储器数量
            printCpuPerc(cpuList[i]);
        }
    }

    private void printCpuPerc(CpuPerc cpu) {
        System.out.println("CPU用户使用率:    " + CpuPerc.format(cpu.getUser()));// 用户使用率
        System.out.println("CPU系统使用率:    " + CpuPerc.format(cpu.getSys()));// 系统使用率
        System.out.println("CPU当前等待率:    " + CpuPerc.format(cpu.getWait()));// 当前等待率
        System.out.println("CPU当前错误率:    " + CpuPerc.format(cpu.getNice()));//
        System.out.println("CPU当前空闲率:    " + CpuPerc.format(cpu.getIdle()));// 当前空闲率
        System.out.println("CPU总的使用率:    " + CpuPerc.format(cpu.getCombined()));// 总的使用率
    }


    public static void main(String[] args) {

        for(int k=0;k<6;k++){
            Set<String> list = new HashSet<>();
            for(int i=1;i<65;i++){
//                System.out.println(i + " : " + Integer.toBinaryString(i));
                String binStr = Integer.toBinaryString(i);
                Integer index = binStr.length()-1-k;
                if(index<0){
                    continue;
                }
                char a = binStr.charAt(index);
                if(a=='1'){
                    list.add(i+"");
                }
            }

            List<String> list1 = new ArrayList<>();
            list1.add("A");
            list1.add("B");
            list1.add("C");
            list1.add("D");
            list1.add("E");
            list1.add("F");
            System.out.println(list1.get(k) + " : " + list);

        }




//        System.out.println(789);
    }








}
