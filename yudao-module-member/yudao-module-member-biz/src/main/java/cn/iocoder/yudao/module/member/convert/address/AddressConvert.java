package cn.iocoder.yudao.module.member.convert.address;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.ip.core.utils.AreaUtils;
import cn.iocoder.yudao.module.member.api.address.dto.AddressRespDTO;
import cn.iocoder.yudao.module.member.controller.admin.address.vo.AddressCreateReqVO;
import cn.iocoder.yudao.module.member.controller.admin.address.vo.AddressExcelVO;
import cn.iocoder.yudao.module.member.controller.admin.address.vo.AddressRespVO;
import cn.iocoder.yudao.module.member.controller.admin.address.vo.AddressUpdateReqVO;
import cn.iocoder.yudao.module.member.controller.app.address.vo.AppAddressCreateReqVO;
import cn.iocoder.yudao.module.member.controller.app.address.vo.AppAddressRespVO;
import cn.iocoder.yudao.module.member.controller.app.address.vo.AppAddressUpdateReqVO;
import cn.iocoder.yudao.module.member.dal.dataobject.address.MemberAddressDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户收件地址 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface AddressConvert {

    AddressConvert INSTANCE = Mappers.getMapper(AddressConvert.class);

    MemberAddressDO convert(AppAddressCreateReqVO bean);

    MemberAddressDO convert(AppAddressUpdateReqVO bean);

    @Mapping(source = "areaId", target = "areaName",  qualifiedByName = "convertAreaIdToAreaName")
    AppAddressRespVO convert(MemberAddressDO bean);

    List<AppAddressRespVO> convertList(List<MemberAddressDO> list);

    AddressRespDTO convert02(MemberAddressDO bean);

    @Named("convertAreaIdToAreaName")
    default String convertAreaIdToAreaName(Integer areaId) {
        return AreaUtils.format(areaId);
    }

    MemberAddressDO convert(AddressCreateReqVO bean);

    MemberAddressDO convert(AddressUpdateReqVO bean);

    AddressRespVO convert2(MemberAddressDO bean);

    List<AddressRespVO> convertList2(List<MemberAddressDO> list);

    PageResult<AddressRespVO> convertPage(PageResult<MemberAddressDO> page);

    List<AddressExcelVO> convertList02(List<MemberAddressDO> list);
}
