import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class HiddenFunctionButton extends View {

    private int maxCount = 10;
    private int interval = 5;
    private int tapCount;
    private Handler handler;
    private Runnable runnable;

    public HiddenFunctionButton(Context context) {
        super(context);
        initView();
    }

    public HiddenFunctionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public HiddenFunctionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener listener) {
        super.setOnClickListener(view -> {
            tapCount++;
            if (tapCount >= maxCount) {
                tapCount = 0;
                if (listener != null) {
                    listener.onClick(view);
                }
            }
        });
    }

    /**
     * 何回タップで反応するかを設定
     * デフォルト：10回
     * @param maxCount 何回タップで反応するか
     */
    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    /**
     * タップ回数をリセットする間隔を設定
     * デフォルト：5秒
     * @param interval タップ回数をリセットする間隔（秒）
     */
    public void setInterval(int interval) {
        this.interval = interval;
    }

    /**
     * タップ回数をリセットする処理のハンドラを開始
     */
    public void startCountResetHandler() {
        handler.post(runnable);
    }

    /**
     * タップ回数をリセットする処理のハンドラを停止
     */
    public void stopCountResetHandler() {
        handler.removeCallbacks(runnable);
    }

    private void initView() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, interval * 1000);
                tapCount = 0;
            }
        };
    }
}
