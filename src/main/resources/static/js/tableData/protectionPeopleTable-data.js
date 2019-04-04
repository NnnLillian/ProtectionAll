// var selections = []
self.peopleDataInit = function (name) {
    var url, tableName, check, columns;
    var basicColumns = [
        {
            field: 'people_id',
            title: '人员ID',
            align: 'center',
            width: '20%'
        }, {
            field: 'people_name',
            title: '姓名',
            // sortable:false,   //本列不可以排序
            align: 'center',
            width: '20%'
        }, {
            field: 'people_profession',
            title: '专业',
            align: 'center',
            width: '30%'
        }, {
            field: 'people_army_name',
            title: '所属单位',
            align: 'center',
            width: '30%'
            // sortable: true
        }
    ];
    switch (name) {
        case 'teamLeader':
            tableName = "teamLeader-table";
            // 队长一定要从技术勤务科中选择
            url = "/GetPeopleMsg?army_type=expert";
            // url = "js/tableData/json/people.json";
            check = [{
                radio: true,
                formatter: function (value, row, index) {
                    let leader = parseInt(localStorage.getItem("selected_leader"));
                    if (row.people_id === leader) {

                        return {
                            checked: true
                        }
                    }
                    return value;
                }
            }];
            columns = check.concat(basicColumns);
            break;
        case 'deputyHead':
            tableName = "deputyHead-table";
            url = "/GetPeopleMsg?army_type=both";
            // url = "js/tableData/json/people.json";
            check = [{
                radio: true,
                formatter: function (value, row, index) {
                    let leader = parseInt(localStorage.getItem("selected_leader"));
                    if (row.people_id === leader) {
                        return {
                            disabled: true,
                            // checked: true
                        }
                    } else {
                        return {disabled: false}
                    }
                    return value;
                }
            }];
            columns = check.concat(basicColumns);
            break;
        case 'teamMember':
            tableName = "teamMember-table";
            url = "/GetPeopleMsg?army_type=both";
            // url = "js/tableData/json/people.json";
            check = [{
                // field: 'checkStatus',
                // align: 'center',
                checkbox: true,
                formatter: function (value, row, index) {
                    console.log(row);
                    let i = parseInt(localStorage.getItem("selected_people"));
                    let j = parseInt(localStorage.getItem("selected_leader"));
                    if (row.people_id === i || row.people_id === j) {
                        return {
                            disabled: true,
                            checked: true
                        }
                    } else {
                        return {disabled: false}
                    }
                    return value;
                }
            }];
            columns = check.concat(basicColumns);
            break;
    }
    $('#' + tableName).empty();
    $('#' + tableName).bootstrapTable('destroy').bootstrapTable({
        method: "GET",                     //使用get請求到服務器獲取數據
        dataType: "json",
        url: url,
        toolbar: "#toolbar",                //一個jQuery 選擇器，指明自定義的toolbar 例如:#toolbar, .toolbar.
        uniqueId: "id",                    //每一行的唯一標識，一般為主鍵列
        cache: false,                       // 不緩存
        contentType: 'application/json,charset=utf-8',
        striped: false,                      // 隔行加亮
        sidePagination: "client",           //分頁方式：client客户端分頁，server服務端分頁（*）
        sortable: true,                     //是否啟用排序;意味着整個表格都會排序
        sortName: 'people_id',                    // 設置默認排序為 name
        sortOrder: "asc",                   //排序方式
        search: true,                       //是否顯示錶格搜索，此搜索是客户端搜索，不會進服務端，所以，個人感覺意義不大
        // strictSearch: true,              //设置为true启用全匹配搜索
        showColumns: false,                  //是否顯示所有的列
        showRefresh: true,                  //是否顯示刷新按鈕
        // showToggle:true,                    //是否顯示詳細視圖和列表視圖
        clickToSelect: true,                //是否啟用點擊選中行
        pagination: true,                   //是否顯示分頁（*）
        pageNumber: 1,                   //初始化加載第一頁，默認第一頁
        pageSize: 10,                    //每頁的記錄行數（*）
        pageList: [10, 25, 50, 100],     //可供選擇的每頁的行數（*）
        paginationPreText: "<",
        paginationNextText: ">",
        paginationFirstText: "第一页",
        paginationLastText: "最后一页",
        // responseHandler: responseHandler,
        columns: columns,

        onLoadSuccess: function (data) { //加載成功時執行
            console.log("success");
            console.log(data);
        },
        onLoadError: function (res) { //加載失敗時執行
            console.log(res);
        },

        onClickRow: function (row) {
            console.log("clickrow");
            console.log(row);
        },
        onCheckAll: function (rows) {  //获取全部选择的数据
            console.log("checkAll");
            console.log(rows);
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
    $("#teamLeader-table").on('check.bs.table', function (e, row) {
        localStorage.setItem("selected_leader", row.people_id);
        $("#deputyHead-table").bootstrapTable('refresh');
        $('#teamMember-table').bootstrapTable('refresh');
    });
    $("#deputyHead-table").on('check.bs.table', function (e, row) {
        console.info("check row");
        localStorage.setItem("selected_people", row.people_id);
        $('#teamMember-table').bootstrapTable('refresh');
    })
};

// 翻页保留checkBox
// function responseHandler(res) {
//     $.each(res.rows, function (i, row) {
//         row.state = $.inArray(row.id, selections) !== -1;
//     });
//     return res;
// }
//
// function mounted() {
//     $("#teamMember-table").on('check.bs.table check-all.bs.table ' +
//         'uncheck.bs.table uncheck-all.bs.table', function (e, rows) {
//         var ids = $.map(!$.isArray(rows) ? [rows] : rows, function (row) {
//             return row.id
//         });
//         var func = $.inArray(e.type, ['check', 'check-all']) > -1 ? 'union' : 'difference'
//         selections = window._[func](selections, ids)
//     })
// }

// 保障部队人员表的选择
function getTeamLeaderId() {
    return $.map($('#teamLeader-table').bootstrapTable('getSelections'), function (row) {
        return row.people_id;
    });
}

function getDeputyHeadId() {
    return $.map($('#deputyHead-table').bootstrapTable('getSelections'), function (row) {
        return row.people_id;
    });
}

function getTeamMemberId() {
    return $.map($('#teamMember-table').bootstrapTable('getSelections'), function (row) {
        return row.people_id;
    });
}