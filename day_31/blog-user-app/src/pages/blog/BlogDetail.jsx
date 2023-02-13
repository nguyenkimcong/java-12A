import React from "react";

function BlogDetail() {
    return (
        <main className="main">
            <article className="post-single">
                <header className="post-header">
                    <h1 className="post-title">
                        Hướng dẫn tạo tài khoản và sử dụng Chat GPT chỉ với 1
                        cốc trà đá
                    </h1>
                    <div className="post-meta">
                        <span title="2023-02-01 00:00:00 +0000 UTC">
                            01/02/2023
                        </span>
                        &nbsp;·&nbsp;
                    </div>
                </header>
                <div className="post-content">
                    <p>
                        Dạo này Chat GPT đang rất hot, được thần thành hóa lên
                        quá khiến nhiều người lo sợ nó sẽ &ldquo;cướp&rdquo; mất
                        công việc của mình. Vậy Chat GPT cụ thể là gì, dùng như
                        nào?
                    </p>
                </div>
            </article>
        </main>
    );
}

export default BlogDetail;
