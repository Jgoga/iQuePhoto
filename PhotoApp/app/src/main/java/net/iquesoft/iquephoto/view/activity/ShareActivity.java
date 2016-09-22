package net.iquesoft.iquephoto.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import net.iquesoft.iquephoto.R;
import net.iquesoft.iquephoto.common.BaseActivity;
import net.iquesoft.iquephoto.di.IHasComponent;
import net.iquesoft.iquephoto.di.components.DaggerIShareActivityComponent;
import net.iquesoft.iquephoto.di.components.IApplicationComponent;
import net.iquesoft.iquephoto.di.components.IShareActivityComponent;
import net.iquesoft.iquephoto.di.modules.ShareActivityModule;
import net.iquesoft.iquephoto.presenter.ShareActivityPresenterImpl;
import net.iquesoft.iquephoto.view.IShareActivityView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShareActivity extends BaseActivity implements IShareActivityView, IHasComponent<IShareActivityComponent> {

    @Inject
    ShareActivityPresenterImpl presenter;

    private IShareActivityComponent shareActivityComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        ButterKnife.bind(this);
    }

    @Override
    protected void setupComponent(IApplicationComponent component) {
        shareActivityComponent = DaggerIShareActivityComponent.builder()
                .iApplicationComponent(component)
                .shareActivityModule(new ShareActivityModule(this))
                .build();
        shareActivityComponent.inject(this);
    }

    @Override
    public IShareActivityComponent getComponent() {
        return shareActivityComponent;
    }

    @OnClick(R.id.save)
    void onClickSave(View view) {
        // Todo: Save image.
    }

    @OnClick(R.id.facebook)
    void onClickFacebook(View view) {
        // Todo: Publish to Facebook.
    }

    @OnClick(R.id.instagram)
    void onClickInstagram(View view) {
        // Todo: Publish to Instagram.
    }

    @OnClick(R.id.more)
    void onClickMore(View view) {
        // Todo: Share more social network.
    }
}
