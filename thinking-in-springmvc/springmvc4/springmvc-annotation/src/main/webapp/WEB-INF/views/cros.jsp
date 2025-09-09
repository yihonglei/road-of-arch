<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>spring MVC POJO TEST</title>

    <script type="text/javascript">
        
        // //格式化参数
        // let formatParams = (data) => {
        //     if (typeof data == 'string') {
        //         return data
        //     }
        //     let arr = [];
        //     for (let name in data) {
        //         arr.push([encodeURIComponent(name), encodeURIComponent(data[name])].join('='));
        //     };
        //     // 添加一个随机数，防止缓存
        //     return arr.join('&');
        // }
        //
        // //格式化请求URL
        // let formatUrl = (url, string) => [url, string].join(/\?/g.test(url) ? '&' : '?')
        //
        //
        //
        // function JDajax (params){
        //     // ajax请求
        //     let json = (params) => {
        //         params.type = (params.type || 'GET').toUpperCase();
        //         let headers = {
        //             'Content-Type': 'application/application'
        //         }
        //         let data = formatParams(params.data);
        //         let xhr = null;
        //
        //         // 实例化XMLHttpRequest对象
        //         if (window.XMLHttpRequest) {
        //             xhr = new XMLHttpRequest();
        //         } else {
        //             // IE6及其以下版本
        //             xhr = new ActiveXObjcet('Microsoft.XMLHTTP');
        //         };
        //
        //         if (params.headers) {
        //             for (let key in params.headers) {
        //                 headers[key] = params.headers[key]
        //             }
        //         }
        //
        //         // 监听事件
        //         xhr.onreadystatechange = function() {
        //             if (xhr.readyState == 4) {
        //                 let status = xhr.status;
        //                 if (status >= 200 && status < 300) {
        //                     let response = '';
        //                     let type = xhr.getResponseHeader('Content-type') || '';
        //                     if (type.indexOf('xml') !== -1 && xhr.responseXML) {
        //                         response = xhr.responseXML; //Document对象响应
        //                     } else if (/application\/json/.test(type)) {
        //                         response = JSON.parse(xhr.responseText); //JSON响应
        //                     } else {
        //                         response = xhr.responseText; //字符串响应
        //                     };
        //
        //                     if (params.dataType == 'json' && typeof response === 'string') {
        //                         response = JSON.parse(response)
        //                     };
        //
        //                     params.success && params.success(response);
        //                 } else {
        //                     params.error && params.error(status);
        //                 }
        //             }
        //         };
        //         xhr.withCredentials = true;
        //         // 连接和传输数据
        //         if (params.type == 'GET') {
        //             xhr.open(params.type, formatUrl(params.url, data), true);
        //             for (let key in headers) {
        //                 xhr.setRequestHeader(key, headers[key]);
        //             }
        //             xhr.send(null);
        //         } else {
        //             xhr.open(params.type, params.url, true);
        //             for (let key in headers) {
        //                 xhr.setRequestHeader(key, headers[key]);
        //             }
        //             xhr.send(data);
        //         }
        //     }
        //     params = params || {};
        //     params.data = params.data || {};
        //     params.dataType === 'jsonp' ? jsonp(params) : json(params);
        // }
        //
        // JDajax({
        //     url: "www.springboot.com:9000/eg/query",
        //     // url: "https://f.jindanlicai.com/xw-api-gateway/assets/debtAssetsDetailList",
        //     type: "POST",
        //     data: {
        //         "id":1,
        //         "code":200
        //     },
        //     dataType: "json",
        //     success: function(response, xml) {
        //         // 此处放成功后执行的代码
        //         //debugger;
        //     },
        //     fail: function(status) {
        //         // 此处放失败后执行的代码
        //         //debugger;
        //     }
        // });

        // old - bak
        ajax({
            // url: "www.springboot.com:9000/eg/query",
            url: "http://192.168.100.17:7960/xw-api-gateway/assets/debtAssetsDetailList",
            //url: "http://f.jindanlicai.com:7960/xw-api-gateway/assets/debtAssetsDetailList",
            type: "POST",
            data: {
                "type":2
            },
            dataType: "json",
            success: function(response, xml) {
                // 此处放成功后执行的代码
                //debugger;
            },
            fail: function(status) {
                // 此处放失败后执行的代码
                //debugger;
            }
        });

        function ajax(options) {
            options = options || {};
            options.type = (options.type || "GET").toUpperCase();
            options.dataType = options.dataType || "json";
            var params = formatParams(options.data);
            //创建 - 非IE6 - 第一步
            if (window.XMLHttpRequest) {
                var xhr = new XMLHttpRequest();
                xhr.withCredentials = true;
            } else {
                //IE6及其以下版本浏览器
                var xhr = new ActiveXObject('Microsoft.XMLHTTP');
            }
            //接收 - 第三步
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4) {
                    var status = xhr.status;
                    if (status >= 200 && status < 300) {
                        options.success && options.success(xhr.responseText, xhr.responseXML);
                    } else {
                        options.fail && options.fail(status);
                    }
                }
            } //连接 和 发送 - 第二步
            if (options.type == "GET") {
                xhr.open("GET", options.url + "?" + params, true);
                xhr.send(null);
            } else if (options.type == "POST") {
                xhr.open("POST", options.url, true); //设置表单提交时的内容类型
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.send(params);
            }
        }
        //格式化参数
        function formatParams(data) {
            var arr = [];
            for (var name in data) {
                arr.push(encodeURIComponent(name) + "=" + encodeURIComponent(data[name]));
            }
            arr.push(("v=" + Math.random()).replace(".", ""));
            return arr.join("&");
        }
    </script>
</head>

<body>
<a href="" onclick="">crosTest</a>>
</body>
</html>