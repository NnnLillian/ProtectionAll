self.warehouseDataInit = function (name) {
    var url, tableName;
    switch (name) {
        case 'China-India':
            tableName = "China-India-warehouse-Table";
            // local data
            url = "js/tableData/json/elementRepairInfoList/elementRepair" + localStorage.getItem("element_category_id") + ".json";
            break;
        case 'China-Korea':
            tableName = "China-Korea-warehouse-Table";
            url = "";
            break;
        case 'East-China-Sea':
            //省略
            break;
        case 'Capital':
            //省略
            break;
        case 'China-Taiwan':
            //省略
            break;
        case 'South-China-Sea':
            //省略
            break;
    }
    $('#' + tableName).empty();
    $('#' + tableName).bootstrapTable('destroy').bootstrapTable({
        method: "get",                     //使用get請求到服務器獲取數據
        dataType: "json",
        url: url,
        uniqueId: "id",                    //每一行的唯一標識，一般為主鍵列
        cache: false,                       // 不緩存
        contentType: 'application/json,charset=utf-8',
        striped: true,                      // 隔行加亮
        sidePagination: "client",           //分頁方式：client客户端分頁，server服務端分頁（*）
        sortable: true,                     //是否啟用排序;意味着整個表格都會排序
        // search: true,                       //是否顯示錶格搜索，此搜索是客户端搜索，不會進服務端，所以，個人感覺意義不大
        strictSearch: false,              //设置为true启用全匹配搜索
        showColumns: false,                  //是否顯示所有的列
        showRefresh: true,                  //是否顯示刷新按鈕
        // showToggle:true,                    //是否顯示詳細視圖和列表視圖
        clickToSelect: true,                //是否啟用點擊選中行
        minimumCountColumns: 2,          //最少允許的列數
        pagination: true,                   //是否顯示分頁（*）
        pageNumber: 1,                   //初始化加載第一頁，默認第一頁
        pageSize: 10,                    //每頁的記錄行數（*）
        pageList: [10, 25, 50, 100],     //可供選擇的每頁的行數（*）
        paginationPreText: "<",
        paginationNextText: ">",
        paginationFirstText: "第一页",
        paginationLastText: "最后一页",
        // responseHandler: responseHandler,    // 如果json不是 {total:"2" row:{},{}} 的格式
        columns: [
            {
                field: 'warehouse_id',
                title: '工厂ID',
                align: 'center',
                visible: false
            }, {
                field: 'warehouse_name',
                title: '工厂名称',
                align: 'center'
            }, {
                field: 'warehouse_linkman',
                title: '工厂联系人',
                align: 'center'
            }, {
                field: 'warehouse_contact',
                title: '联系方式',
                align: 'center'
            }
        ],

        onLoadSuccess: function (data) { //加載成功時執行
            console.log(data);
        },
        onLoadError: function (res) { //加載失敗時執行
            console.log(res);
        },

        onClickRow: function (row) {  //获取选中行的数据
            console.log("clickrow");
            console.log(row);
        },

        onCheckAll: function (row) {  //获取全部选择的数据
            console.log("clickall");
            console.log(row);
        },

        onUncheck: function (row) {
            console.log("uncheck");
            console.log(row);
        },

        onUncheckAll: function (row) {
            console.log("uncheckall");
            console.log(row);
        }
    });
};