// 페이지가 로드 완료되면...
$(document).ready(function () {

    // 회원가입 버튼을 누르면 가입 페이지로 이동!
    $('#joinBtn').click(function () {
        window.location.href='/join';
    });

    // 로그인 버튼을 누르면 로그인 페이지로 이동!
    $('#loginBtn').click(function () {
        window.location.href='/login';
    });

    // 메인 버튼을 누르면 메인 페이지로 이동!
    $('#home').click(function () {
        window.location.href='/';
    });

    // 글쓰기
    $('#writeBtn').click(function () {
        window.location.href='/write';
    });

    // #id를 변수로 keyValue 담아서 전달
    $('#join').click(function () {
        var data = {
            id : $('#id').val(),
            password : $('#password').val(),
            name : $('#name').val(),
            type : $('#type').val()
        };

        $.ajax({
            type: 'post',
            url: '/rest/join',
            data: data
        }).done(function(){
            alert("회원가입 완료!");
            window.location.href='/';
        }).fail(function (error) {
            alert(error);
        });
    });

    // #id를 변수로 keyValue 담아서 전달
    $('#login').click(function () {
        var data = {
            id : $('#loginid').val(),
            password : $('#loginpassword').val(),
        };

        $.ajax({
            type: 'post',
            url: '/rest/login',
            data: data
        }).done(function(){
            alert("로그인 성공!");
            window.location.href='/';
        }).fail(function (error) {
            alert(error);
        });
    });

    // 글쓰기 데이터 전달
    $('#reg').click(function () {
        var data = {
            mno : $('#mno').val(),
            type : $('#type').val(),
            title : $('#title').val(),
            content : $('#content').val(),
            writer : $('#writer').val()
        };

        $.ajax({
            type: 'post',
            url: '/rest/write',
            data: data
        }).done(function(){
            alert("게시글 등록 완료!");
            window.location.href='/';
        }).fail(function (error) {
            alert(error);
        });
    });

    // 추천
    $('#reco').click(function () {
        var data = {
            bno : $('#bno').val(),
            type : $('#type').val(),
        };

        $.ajax({
            type: 'post',
            url: '/rest/reco',
            data: data
        }).done(function(){
            alert("추천하셨습니다!");
            window.location.href='/';
        }).fail(function (error) {
            alert(error);
        });
    });

    // 수정 페이지 이동
    $('#updateBtn').click(function () {
        var bno = $('#bno').val();
        window.location.href='/update/'+bno;
    });

    // 추천
    $('#delete').click(function () {
        var data = {
            bno : $('#bno').val()
        };

        $.ajax({
            type: 'post',
            url: '/rest/delete',
            data: data
        }).done(function(){
            alert("해당 게시글이 삭제되었습니다!");
            window.location.href='/';
        }).fail(function (error) {
            alert(error);
        });
    });

    // 수정
    $('#update').click(function () {
        var data = {
            bno : $('#bno').val(),
            title : $('#title').val(),
            content : $('#content').val(),
            writer : $('#writer').val()
        };

        $.ajax({
            type: 'post',
            url: '/rest/update',
            data: data
        }).done(function(){
            alert("게시글 수정 성공!");
            window.location.href='/';
        }).fail(function (error) {
            alert(error);
        });
    });

    // 댓글
    $('#reply').click(function () {
        var bno = $('#bno').val();

        var data = {
            bno : $('#bno').val(),
            re_writer : $('#re_writer').val(),
            re_content : $('#re_content').val(),
            mno : $('#mno').val()
        };

        $.ajax({
            type: 'post',
            url: '/rest/reply',
            data: data
        }).done(function(){
            alert("댓글 등록!");
            window.location.href='/select/' + bno;
        }).fail(function (error) {
            alert(error);
        });
    });

    // count
    $('#count').click(function () {
        var data = {
            mno : $('#mno').val(),
            title : $('#title').val(),
            type : $('#type').val(),
        };

        $.ajax({
            type: 'post',
            url: '/rest/readcount',
            data: data
        }).done(function(){

        }).fail(function (error) {
            alert(error);
        });
    });

});
