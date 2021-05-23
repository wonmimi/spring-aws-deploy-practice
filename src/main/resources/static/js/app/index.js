var main = {
    init : function () {
        var _this = this;

        //등록
        $('#btn-save').on('click', function() {
            _this.save();
        });

        //수정
        $('#btn-update').on('click',function(){
            _this.update();
        });

    },
    save : function() {
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };

        $.ajax({
            type:'POST',
            url:'/api/v1/posts',
            dataType:'json',
            contentType:'application/json; charset-uyf-8',
            data: JSON.stringify(data),
        }).done(function(){
            alert('글이 등록 되었습니다.');
            window.location.href = '/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });

    },

    update : function(){
        var data = {
            title : $('#title').val(),
            content : $('#content').val()
        };
        var id = $('#id').val();

         $.ajax({
            type:'PUT',
            url:'/api/v1/posts/'+id,
            dataType:'json',
            contentType:'application/json; charset-uyf-8',
            data: JSON.stringify(data),
        }).done(function(){
            alert('글이 수정 되었습니다.');
            window.location.href = '/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });

    }
};

main.init();