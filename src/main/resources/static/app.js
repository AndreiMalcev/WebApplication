$('#jstree').jstree({
    "core" : {
        "animation" : 0,
        "check_callback" : true,
        "themes" : { "stripes" : true },
        'data' : {
            'url' : function (node) {
                return 'get';
            },
            'data' : function (node) {
                return { 'id' : node.id };
            }
        }
    },

        "plugins" : [
            "contextmenu", "dnd", "wholerow", "unique", "json_data"
        ]}).on('rename_node.jstree', function (e, data) {
            $.post('rename', { 'id' : data.node.id, 'text' : data.text })
        .fail(function () {
            data.instance.refresh();
        });
        }).on('create_node.jstree', function (e, data) {
    $.post('create', { 'id' : data.node.parent, 'position' : data.position, 'text' : data.node.text })
        .done(function (d) {
            data.instance.set_id(data.node, d.id);
        })
        .fail(function () {
            data.instance.refresh();
        })}).on('delete_node.jstree', function (e, data) {
    $.post('delete', {'id': data.node.id}).fail(function () {
        data.instance.refresh();
    });
    }).on('move_node.jstree', function (e, data) {
    $.post('change', {'id': data.node.id, 'newParent' : data.node.parent}).fail(function () {
        data.instance.refresh();
    })
});