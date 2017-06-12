/**
* 支持的方法:
* yield:渲染内容,但是渲染前会转义
* yieldUnescaped:渲染原始内容,渲染后不进行转义
* xmlDeclaration:渲染XML声明字符串,如果在配置文件中编码进行了声明,则会写入XML声明
*   模板：xmlDeclaration()输出<?xml version='1.0'?>;如果TemplateConfiguration#getDeclarationEncoding非空输出<?xml version='1.0'encoding='UTF-8'?>
* comment:渲染原始内容到XML的注释中
* newLine:模板:p(‘text’)newLine()p(‘text on new line’)输出：<p>text</p><p>text on new line</p>
* pi:渲染XML处理声明,模板pi(“xml-stylesheet”:[href:”mystyle.css”,type:”text/css”])输出：<?xml-stylesheet href=’mystyle.css’type=’text/css’?>
* tryEscape:如果是对象字符串,从实体对象渲染转义的字符串,否则返回实体对象本身
*/
yieldUnescaped '<!DOCTYPE html>'
html {
    head {
        meta(charset:"utf-8")
        /** key:value形式,而多个属性使用逗号分割,若有-如:http-equiv需要使用引号,否则报错 */
        meta("http-equiv":"X-UA-Compatible", content:"IE=edge")
        meta(name:"viewport", content:"width=device-width,initial-scale=1")
        title('Groovy模板测试')
        link(type:"text/css", rel:"stylesheet", href:request.getContextPath() + "/plugins/bootstrap-3.3.7/css/bootstrap.min.css")
        link(type:"text/css", rel:"stylesheet", href:request.getContextPath() + "/plugins/bootstrap-3.3.7/plugins/table-1.11.1/bootstrap-table.min.css")
        link(type:"text/css", rel:"stylesheet", href:request.getContextPath() + "/plugins/bootstrap-3.3.7/plugins/table-1.11.1/extensions/sticky-header/bootstrap-table-sticky-header.css")
        link(type:"text/css", rel:"stylesheet", href:request.getContextPath() + "/plugins/bootstrap-3.3.7/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css")
        link(type:"text/css", rel:"stylesheet", href:request.getContextPath() + "/plugins/artDialog4.1.7/skins/black.css")
        link(type:"text/css", rel:"stylesheet", href:request.getContextPath() + "/css/demo.css")
        yieldUnescaped '<!--[if lt IE 9]>'
            script(type:"text/javascript", src:request.getContextPath() + "/plugins/html5shiv-3.7.3/html5shiv.min.js")
            script(type:"text/javascript", src:request.getContextPath() + "/plugins/respond-1.4.2/respond.min.js")
        yieldUnescaped '<![endif]-->'
    }
    body{
        input(type:"hidden", id:"urlPath", value: request.getContextPath())
        div(class:"container") {
            div(class:"row") {
                span(class:"glyphicon glyphicon-star", "使用的模板:")
                span(class:"lead", "groovy")
            }
            div(class:"row") {
                span(class:"glyphicon glyphicon-user", "欢迎您:" + loginUserCode)
            }
            div(class:"row mt20") {
                form(class:"form-inline") {
                    div(class:"form-group") {
                        label(for:"name", "&nbsp;&nbsp;&nbsp;名称")
                        input(type:"text", class:"form-control", id:"name", placeholder:"请输入名称...")
                    }
                    div(class:"form-group") {
                        label(for:"compareStatus", "&nbsp;&nbsp;&nbsp;同步状态")
                        select(class:"form-control", id:"compareStatus", name:"compareStatus", style:"min-width:120px;") {
                            option(value:"-1", selected:"selected", "所有")
                            option(value:"1", "新增")
                            option(value:"2", "修改")
                            option(value:"3", "删除")
                        }
                    }
                    div(class:"form-group") {
                        label(for:"syncStartTime", "&nbsp;&nbsp;&nbsp;同步时间")
                        input(type:"text", class:"form-control input-append date form_datetime", id:"syncStartTime", name:"syncStartTime", style:"min-width: 205px;")
                        label(for:"syncEndTime", "至")
                        input(type:"text", class:"form-control input-append date form_datetime", id:"syncEndTime", name:"syncEndTime", style:"min-width: 205px;")
                    }
                    span("&nbsp;&nbsp;")
                    div(class:"form-group") {
                        button(class:"btn btn-info", type:"button", id:"selectBth") {
                            span(class:"glyphicon glyphicon-search", "查询")
                        }
                        span("&nbsp;&nbsp;")
                        button(class:"btn btn-default", type:"reset") {
                            span(class:"glyphicon glyphicon-refresh", "重置")
                        }
                    }
                }
            }
            div(class:"table-responsive", id:"syncHostTableDiv", style:"min-height: 400px; margin-top: 10px;") {
                table(id:"syncHostTableBody")
            }
        }
        script(type:"text/javascript", src:request.getContextPath() + "/plugins/jquery-1.10.2.min.js")
        script(type:"text/javascript", src:request.getContextPath() + "/plugins/bootstrap-3.3.7/js/bootstrap.min.js")
        script(type:"text/javascript", src:request.getContextPath() + "/plugins/bootstrap-3.3.7/plugins/table-1.11.1/bootstrap-table.min.js")
        script(type:"text/javascript", src:request.getContextPath() + "/plugins/bootstrap-3.3.7/plugins/table-1.11.1/locale/bootstrap-table-zh-CN.min.js")
        script(type:"text/javascript", src:request.getContextPath() + "/plugins/bootstrap-3.3.7/plugins/datetimepicker/bootstrap-datetimepicker.min.js")
        script(type:"text/javascript", src:request.getContextPath() + "/plugins/bootstrap-3.3.7/plugins/datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js")
        script(type:"text/javascript", src:request.getContextPath() + "/plugins/bootstrap-3.3.7/plugins/table-1.11.1/extensions/sticky-header/bootstrap-table-sticky-header.min.js")
        script(type:"text/javascript", src:request.getContextPath() + "/plugins/artDialog4.1.7/artDialog.js")
        script(type:"text/javascript", src:request.getContextPath() + "/js/demo.js")
    }
}