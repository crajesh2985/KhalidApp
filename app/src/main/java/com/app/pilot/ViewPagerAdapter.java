package com.app.pilot;

import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerAdapter extends PagerAdapter {

  private SparseArray<View> viewPagerMap = new SparseArray<>();

  @Override
  public int getCount() {
    return viewPagerMap.size();
  }

  @Override
  public Object instantiateItem(ViewGroup container, int position) {
    View pageView = viewPagerMap.get(position);
    container.addView(pageView);
    return pageView;
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
    viewPagerMap.remove(position);
    View pageView = (View) object;
    container.removeView(pageView);
  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
    return view == object;
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return ((PageContainer) viewPagerMap.get(position)).getTitle();
  }

  public void addView(View view, int position) {
    if (view instanceof PageContainer) {
      viewPagerMap.put(position, view);
    } else {
      throw new IllegalArgumentException("View must be implement PageContainer");
    }
  }

  public interface PageContainer {
    String getTitle();
  }
}
