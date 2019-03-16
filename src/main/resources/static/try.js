// var queryParams = function (params) {
//     var param = {
//         pageIndex: Math.ceil(params.offset / params.limit) + 1,
//         pageSize: params.limit,
//         order: params.order,
//         ordername: params.sort,
//         startDateTime: $("#dateSearch .startDate").val(),
//         endDateTime: $("#dateSearch .endDate").val(),
//         search: $("#dateSearch .imuserid").val()
//     };
//     return param;
// }
//
// var responseHandler = function (e) {
//     console.log(e);
//     if (e.data && e.data.length > 0) {
//         return { "rows": e.data, "total": e.count };
//     }
//     else {
//         return { "rows": [], "total": 0 };
//     }
//
// }
// var uidHandle = function (res) {
//     var html = "<a href='#'>"+ res + "</a>";
//     return html;
// }
// var operateFormatter = function (value, row, index) {//賦予的參數
//     return [
//         '<button class="btn btn-info btn-sm rightSize detailBtn" type="button"><i class="fa fa-paste"></i> 詳情</button>',
//         '<button class="btn btn-danger btn-sm rightSize packageBtn" type="button"><i class="fa fa-envelope"></i> 通知</button>'
//     ].join('');
// }
self.dataInit = function (name) {
    var url, columns, tableName;
    switch (name) {
        case 'loginLogTab':
            tableName = "loginLog-table";
            columns = [
                {
                    checkbox: true
                },
                {
                    field: 'uid',
                    title: '用户編號',
                    align: 'center',
                    // formatter: uidHandle,//自定義方法設置uid跳轉鏈接
                    width:300
                }, {
                    field: 'name',
                    title: '姓名',
                    align: 'center',
                    sortable:false   //本列不可以排序
                }, {
                    field: 'sex',
                    title: '性別',
                    align: 'center'
                }, {
                    field: 'age',
                    title: '年齡',
                    align: 'center',
                    sortable: true,
                    clickToSelect: false,
                    sortName: "age",
                    order:"asc"
                }, {
                    field: 'area',
                    title: '户籍所在地',
                    align: 'left',
                    halign:'center' //設置表頭列居中對齊
                }, {
                    field: 'loginWay',
                    title: '登錄方式',
                    align: 'center'
                }, {
                    field: 'status',
                    title: '狀態',
                    align: 'center'
                },{
                    field: 'createTime',
                    title: '登錄時間',
                    align: 'center',
                    width: 90
                }, {
                    field: 'orderService',
                    title: '購買服務',
                    align: 'center'
                }, {
                    field: 'connectorIP',
                    title: '連接器IP',
                    align: 'center'
                }, {
                    field: 'connectorPort',
                    title: '連接器端口',
                    align: 'center'
                }, {
                    field: 'operate',
                    title: '操作',
                    align: 'center',
                    valign: 'middle',
                    // formatter: operateFormatter //自定義方法，添加操作按鈕
                }
            ];
            break;
        case 'receiveLogTab':
            tableName = "receiveLog-table";
            columns = [
                {
                    checkbox: true
                },
                {
                    field: 'uid',
                    title: '用户編號',
                    align: 'center',
                    // formatter: uidHandle,//自定義方法設置uid跳轉鏈接
                    width:300
                }, {
                    field: 'name',
                    title: '姓名',
                    align: 'center',
                    sortable:false   //本列不可以排序
                }, {
                    field: 'sex',
                    title: '性別',
                    align: 'center'
                }, {
                    field: 'age',
                    title: '年齡',
                    align: 'center',
                    sortable: true,
                    clickToSelect: false,
                    sortName: "age",
                    order:"asc"
                }, {
                    field: 'area',
                    title: '户籍所在地',
                    align: 'left',
                    halign:'center' //設置表頭列居中對齊
                }, {
                    field: 'loginWay',
                    title: '登錄方式',
                    align: 'center'
                }
            ];
            break;
        case 'socketInputTab':
            //省略
            break;
        case 'socketOutputTab':
            //省略
            break;
    }
    $('#' + tableName).empty();
    $('#' + tableName).bootstrapTable('destroy').bootstrapTable({
        url: '../data/login_info2.json',   //url一般是請求後台的url地址,調用ajax獲取數據。此處我用本地的json數據來填充表格。
        method: "get",                     //使用get請求到服務器獲取數據
        dataType: "json",
        contentType: 'application/json,charset=utf-8',
        toolbar: "#toolbar",                //一個jQuery 選擇器，指明自定義的toolbar 例如:#toolbar, .toolbar.
        uniqueId: "id",                    //每一行的唯一標識，一般為主鍵列
        height: document.body.clientHeight-165,   //動態獲取高度值，可以使表格自適應頁面
        cache: false,                       // 不緩存
        striped: true,                      // 隔行加亮
        queryParamsType: "limit",           //設置為"undefined",可以獲取pageNumber，pageSize，searchText，sortName，sortOrder
                                            //設置為"limit",符合 RESTFul 格式的參數,可以獲取limit, offset, search, sort, order
        // queryParams: queryParams,
        sidePagination: "server",           //分頁方式：client客户端分頁，server服務端分頁（*）
        // sortable: true,                     //是否啟用排序;意味着整個表格都會排序
        sortName: 'uid',                    // 設置默認排序為 name
        sortOrder: "asc",                   //排序方式
        pagination: true,                   //是否顯示分頁（*）
        search: true,                       //是否顯示錶格搜索，此搜索是客户端搜索，不會進服務端，所以，個人感覺意義不大
        strictSearch: true,
        showColumns: true,                  //是否顯示所有的列
        showRefresh: true,                  //是否顯示刷新按鈕
        showToggle:true,                    //是否顯示詳細視圖和列表視圖
        clickToSelect: true,                //是否啟用點擊選中行
        minimumCountColumns: 2,          //最少允許的列數 clickToSelect: true, //是否啟用點擊選中行
        pageNumber: 1,                   //初始化加載第一頁，默認第一頁
        pageSize: 10,                    //每頁的記錄行數（*）
        pageList: [10, 25, 50, 100],     //可供選擇的每頁的行數（*）
        paginationPreText: "Previous",
        paginationNextText: "Next",
        paginationFirstText: "First",
        paginationLastText: "Last",
        // responseHandler: responseHandler,
        columns: columns,
        onLoadSuccess: function (data) { //加載成功時執行
            console.log(data);
        },
        onLoadError: function (res) { //加載失敗時執行
            console.log(res);
        }
    });
}