package com.czl.module_user.viewmodel

import com.czl.lib_base.base.BaseViewModel
import com.czl.lib_base.data.DataRepository
import com.czl.lib_base.base.MyApplication
import com.czl.lib_base.binding.command.BindingAction
import com.czl.lib_base.binding.command.BindingCommand
import com.czl.lib_base.event.LiveBusCenter


/**
 * @author Alwyn
 * @Date 2020/10/19
 * @Description
 */
class SecFmViewModel(application: MyApplication, model: DataRepository) :
    BaseViewModel<DataRepository>(application, model) {
    val secOnClick: BindingCommand<Any> = BindingCommand(BindingAction {
        // 发送消息
        LiveBusCenter.postMainEvent("这是来自SecFragment的事件")
    })
}