self.SupplyInit = function (name) {
    var url, columns, tableName;
    switch (name) {
        case 'supplyMessage':
            tableName = "NearbySupply-table";
            url = "/GetSupplierMsg?case_position=" + localStorage.getItem("case_position");
            columns = [
                // {
                //     checkbox: true
                // },
                {
                    field: 'supplier_id',
                    title: '公司名称',
                    align: 'center',
                    visible: false
                },
                {
                    field: 'supplier_name',
                    title: '公司名称',
                    align: 'center'
                }, {
                    field: 'supplier_head',
                    title: '联系人',
                    align: 'center'
                }, {
                    field: 'supplier_phone',
                    title: '联系方式',
                    align: 'center'
                }, {
                    field: 'position_name',
                    title: '地址',
                    align: 'center'
                }, {
                    field: 'supplier_type_name',
                    title: '资源类型',
                    align: 'center'
                }
            ];
            break;
        case 'socketOutputTab':
            //省略
            break;
    }
    $('#' + tableName).empty();
    $('#' + tableName).bootstrapTable('destroy').bootstrapTable({
        method: "get",                     //使用get請求到服務器獲取數據
        dataType: "json",
        url: url,
        contentType: "application/x-www-form-urlencoded",
        // toolbar: "#toolbar",                //一個jQuery 選擇器，指明自定義的toolbar 例如:#toolbar, .toolbar.
        // uniqueId: "id",                    //每一行的唯一標識，一般為主鍵列
        // height: document.body.clientHeight,   //動態獲取高度值，可以使表格自適應頁面
        cache: false,                       // 不緩存
        // url: '../data/login_info2.json',   //url一般是請求後台的url地址,調用ajax獲取數據。此處我用本地的json數據來填充表格。
        // contentType: 'application/json,charset=utf-8',
        striped: true,                      // 隔行加亮
        // queryParamsType: "limit",           //設置為"undefined",可以獲取pageNumber，pageSize，searchText，sortName，sortOrder
        //設置為"limit",符合 RESTFul 格式的參數,可以獲取limit, offset, search, sort, order
        // queryParams: queryParams,
        sidePagination: "client",           //分頁方式：client客户端分頁，server服務端分頁（*）
        // sortable: true,                     //是否啟用排序;意味着整個表格都會排序
        // sortName: 'uid',                    // 設置默認排序為 name
        // sortOrder: "asc",                   //排序方式
        // search: true,                       //是否顯示錶格搜索，此搜索是客户端搜索，不會進服務端，所以，個人感覺意義不大
        // strictSearch: true,              //设置为true启用全匹配搜索
        showColumns: true,                  //是否顯示所有的列
        // showRefresh: true,                  //是否顯示刷新按鈕
        // showToggle:true,                    //是否顯示詳細視圖和列表視圖
        clickToSelect: true,                //是否啟用點擊選中行
        minimumCountColumns: 2,          //最少允許的列數
        pagination: true,                //是否顯示分頁（*）
        pageNumber: 1,                   //初始化加載第一頁，默認第一頁
        pageSize: 10,                    //每頁的記錄行數（*）
        pageList: [10, 25, 50, 100],     //可供選擇的每頁的行數（*）
        paginationPreText: "<",
        paginationNextText: ">",
        paginationFirstText: "第一页",
        paginationLastText: "最后一页",
        // responseHandler: responseHandler,    // 如果json不是 {total:"2" row:{},{}} 的格式
        columns: columns,
        onLoadSuccess: function (data) { //加載成功時執行
            console.log(data);
        },
        onLoadError: function (res) { //加載失敗時執行
            console.log(res);
        },

        onCheck: function (row) {  //获取选中行的数据
            console.log("clickrow");
            msg = "clickrow";
            console.log(row);
            selections = [msg, row];
        },

        onCheckAll: function (row) {  //获取全部选择的数据
            console.log("clickall")
            console.log(row);
        },

        onUncheck: function (row) {
            console.log("uncheck")
            console.log(row);
        },

        onUncheckAll: function (row) {
            console.log("uncheckall")
            console.log(row);
        }
    });
};
