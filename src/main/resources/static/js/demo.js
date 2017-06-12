/**
 * 数据表格-js部分
 * Created by Song on 2017/6/7
 */

var urlPath = $('#urlPath').val();
$(function () {
    $('form')[0].reset();
    // 同步时间选择框
    var $startTime = $('#syncStartTime');
    var $endTime = $('#syncEndTime');
    $startTime.datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        autoclose: true,
        todayBtn: true,
        minuteStep: 10,
        language: 'zh-CN'
    }).on('changeDate', function (ev) {
        var _endTime = $endTime.val();
        if ($.trim(_endTime) !== '' && ev.date.valueOf() > new Date(_endTime).valueOf()) {
            art.dialog({content: '不能迟于结束时间！', title: '提示', icon: 'warning', time: 3});
            $startTime.val('');
        }
    });
    $endTime.datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        autoclose: true,
        todayBtn: true,
        minuteStep: 10,
        language: 'zh-CN'
    }).on('changeDate', function (ev) {
        var _startTime = $startTime.val();
        if ($.trim(_startTime) !== '' && ev.date.valueOf() < new Date(_startTime).valueOf()) {
            art.dialog({content: '不能早于开始时间！', title: '提示', icon: 'warning', time: 3});
            $endTime.val('');
        }
    });
    // 加载数据表格
    var $table = $('#syncHostTableBody');
    var $name = $('#name');
    var $compareStatus = $('#compareStatus');
    bootstrapTableConfig($table, $name, $compareStatus, $startTime, $endTime);
    // 查询按钮点击事件
    $('#selectBtn').click(function () {
        $table.bootstrapTable('refresh');
    });
});

// 构造表格数据
function bootstrapTableConfig($table, $name, $compareStatus, $startTime, $endTime) {
    var stickyHeaderOffsetY = 0;
    var $navbarFixedTop = $('.navbar-fixed-top');
    if ($navbarFixedTop.css('height')) {
        stickyHeaderOffsetY = +$navbarFixedTop.css('height').replace('px', '');
    }
    if ($navbarFixedTop.css('margin-bottom')) {
        stickyHeaderOffsetY += +$navbarFixedTop.css('margin-bottom').replace('px', '');
    }
    $table.bootstrapTable({
        pageSize:3, // 默认10,测试由于数据量小修改为3
        striped: false,
        url: urlPath + '/table/queryTableData',
        cache: false,
        search: false,
        pagination: true,
        showRefresh: true,
        showColumns: true,
        showToggle: false,
        idField: 'id',
        sidePagination: "server",
        clickToSelect: true,
        singleSelect: false,
        checkboxHeader: false,
        maintainSelected: false,
        stickyHeader: true,
        stickyHeaderOffsetY: stickyHeaderOffsetY + 'px',
        columns: [
            {checkbox: true, align: 'center', switchable: false},
            {field: 'id', title: 'ID', align: 'center', visible: false, switchable: false},
            {field: 'hostId', title: '主机表ID', align: 'center', visible: false, switchable: false},
            {field: 'name', title: '名称', align: 'center', sortable: true},
            {field: 'hostName', title: '主机名', align: 'center', switchable: false},
            {field: 'manageIp', title: 'IP地址', align: 'center', switchable: false},
            {field: 'cpuFamily', title: 'CPU型号', align: 'center'},
            {field: 'operateSystem', title: '操作系统', align: 'center', switchable: false},
            {field: 'osVersion', title: '操作系统版本', align: 'center', visible: false},
            {field: 'serialNumber', title: '序列号', align: 'center', visible: false},
            {field: 'manufacturerText', title: '制造商', align: 'center', visible: false},
            {field: 'physicalCpus', title: '物理CPU数', align: 'center'},
            {field: 'memorySize', title: '内存大小', align: 'center', formatter: function (value) {
                return number2Mb(value);
            }},
            {field: 'diskCount', title: '磁盘数量', align: 'center', visible: false},
            {field: 'totalDiskSize', title: '磁盘大小', align: 'center', visible: false, formatter: function (value) {
                return number2Gb(value);
            }},
            {field: 'inmCompareStatus', title: '同步状态', align: 'center', formatter: function (value) {
                return value === 1 ? '新增' : value === 2 ? '修改' : value === 3 ? '删除' : '-';
            }},
            {field: 'inmSyncTime', title: '同步时间', align: 'center', sortable: true}
        ],
        queryParams: function (param) {
            return {
                name: $name.val(),
                compareStatus: $compareStatus.val(),
                startTime: $startTime.val(),
                endTime: $endTime.val(),
                limit: param.limit,
                offset: param.offset,
                sort: param.sort,
                order: param.order
            };
        },
        onLoadError: function () {
            $table.bootstrapTable('load', {total: 0, rows: []});
            art.dialog({content: '表格数据加载失败！', title: '提示', icon: 'face-sad', time: 3});
        }
    });
}

// 数字转为MB与GB展示
function number2Gb(value) {
    return isNaN(value) ? '-' : (value / (1024 * 1024 * 1024)).toFixed(2) + 'GB';
}
function number2Mb(value) {
    return isNaN(value) ? '-' : (value / (1024 * 1024)).toFixed(2) + 'MB';
}